package com.example.application.views.helloworld;

import java.net.URLDecoder;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

import com.vaadin.flow.component.Key;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.BeforeEvent;
import com.vaadin.flow.router.HasUrlParameter;
import com.vaadin.flow.router.Menu;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouteAlias;

@PageTitle("Hello World")
@Menu(icon = "line-awesome/svg/globe-solid.svg", order = 0)
@Route(value = "")
@RouteAlias(value = "")
public class HelloWorldView extends HorizontalLayout implements HasUrlParameter<String>
{
    private static final long serialVersionUID = -3395224389731979640L;

    private TextField input;
    private Button send;
    private TextField output;

    public HelloWorldView()
    {
        input = new TextField( "URI parameter" );
        send = new Button( "Send" );
        send.addClickListener( e -> {
            String value = input.getValue( );
            value = URLEncoder.encode( value, StandardCharsets.UTF_8 );
            UI.getCurrent( ).navigate( "/" + value );
        } );
        send.addClickShortcut( Key.ENTER );
        output = new TextField( "Received via url" );
        output.setReadOnly( true );

        setMargin( true );
        setVerticalComponentAlignment( Alignment.END, input, send, output );

        add( input, send, output );
    }

    @Override
    public void setParameter(BeforeEvent event, String parameter)
    {
        output.setValue( URLDecoder.decode( parameter, StandardCharsets.UTF_8 ) );
    }

}

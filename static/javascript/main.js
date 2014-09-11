(function($){
	"use strict";
	$(function() {
		$('body').terminal(function(command, term) {
			if (command !== '') {
				var commandData = JSON.stringify($.terminal.parseCommand(command));
				$.getJSON( "/cmd/", {data : commandData}, function( response ) {
					if(response.type === 'success'){
						if(response.raw == true){
							term.echo(response.data, {raw : true});	
						}else{
							term.echo(response.data);
						}
					}else{
						term.error(response.data);
					}
				});
			} else {
				term.echo('');
			}
		}, {
			greetings: 	"       _                              _                  \n" +
						"      | |                            (_)                 \n" +
						"   ___| |     ___ _ __ ___  _ __ ___  _ _ __   __ _ ___  \n" +
						"  / _ \\ |    / _ \\ '_ ` _ \\| '_ ` _ \\| | '_ \\ / _` / __| \n" +
						" |  __/ |___|  __/ | | | | | | | | | | | | | | (_| \\__ \\  \n" +
						"  \\___\\_____/\\___|_| |_| |_|_| |_| |_|_|_| |_|\\__, |___/ \n" +
						"                                               __/ |     \n" +
						"     Welcome to eLemmings website.            |___/      \n" +
						"\n " +
						"Type 'help' to see available commands.",
		    onBlur: function() {
		        return false;
		    },
			name: 'eLemmings',
			height: 200,
			prompt: '>> '
		});
	
	});
})($);

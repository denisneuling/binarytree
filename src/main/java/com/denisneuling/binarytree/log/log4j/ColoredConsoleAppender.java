package com.denisneuling.binarytree.log.log4j;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Appender;
import org.apache.log4j.Layout;
import org.apache.log4j.Level;
import org.apache.log4j.spi.LoggingEvent;
import org.apache.log4j.spi.OptionHandler;

import com.denisneuling.binarytree.log.colors.Colors;

public class ColoredConsoleAppender extends org.apache.log4j.ConsoleAppender implements Appender, OptionHandler {

	protected Map<Level, String> colors = new HashMap<Level, String>();

	public ColoredConsoleAppender() {
		colors.put(Level.ALL, Colors.RESET);
		colors.put(Level.TRACE, Colors.RESET);
		colors.put(Level.DEBUG, Colors.WHITEF);
		colors.put(Level.INFO, Colors.RESET);
		colors.put(Level.WARN, Colors.BLUEF);
		colors.put(Level.ERROR, Colors.REDF);
		colors.put(Level.FATAL, Colors.MAGENTAF);
		colors.put(Level.OFF, Colors.CYANF);
	}

	protected void subAppend(LoggingEvent event) {

		String formatted = this.layout.format(event);
		String colored = inquireColor(formatted, event);

		this.qw.write(colored);

		if (layout.ignoresThrowable()) {
			String[] s = event.getThrowableStrRep();
			if (s != null) {
				int len = s.length;
				for (int i = 0; i < len; i++) {
					this.qw.write(inquireColor(s[i], event));
					this.qw.write(Layout.LINE_SEP);
				}
			}
		}

		if (shouldFlush(event)) {
			this.qw.flush();
		}
	}

	protected String inquireColor(String message, LoggingEvent event){
		Level currentLevel = event.getLevel();
		String format = colors.get(currentLevel);

		if(format == null)
			return message;

		return Colors.colored(message, format);
	}
}
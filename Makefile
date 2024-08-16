cli_game: 
	javac -d target src/guesser/cli/GuesserCLI.java;
	java -cp target guesser.cli.GuesserCLI;

gui_game:
	javac -d target -sourcepath src src/guesser/gui/Launcher.java;
	java -cp target guesser.gui.Launcher

clean:
	rm -rf target/guesser
	rm -rf target/Test

rm_stats:
	rm target/stat.csv
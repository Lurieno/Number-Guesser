cli_game: 
	javac -d target src/guesser/cli/GuesserCLI.java;
	java -cp target/ guesser.cli.GuesserCLI;

gui_game:
	javac -d target/ src/guesser/gui/GUI.java src/guesser/gui/Game.java;
	java -cp target/ guesser.gui.Game

clean:
	rm -rf target/guesser
	rm -rf target/Test

rm_stats:
	rm target/stat.csv
cli_game: 
	javac -d target src/guesser/cli/GuesserCLI.java;
	java -cp target/ guesser.cli.GuesserCLI;

gui_game:
	javac -d target/ src/guesser/gui/JFrameWrapper.java src/guesser/gui/GuesserGUI.java;
	java -cp target/ guesser.gui.GuesserGUI

clean:
	rm -rf target/guesser
	rm -rf target/Test

rm_stats:
	rm target/stat.csv
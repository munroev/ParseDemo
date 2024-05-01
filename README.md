# Original Version

## Getting Started

This was originally a Java Applet written by professor Zerksis D. Umrigar to demonstrate parsing algorithms with a custom context free grammar. This app is now used as a learning tool by Professor Charles T. Wilkes at the University Of Massachusetts Lowell in the Organization Of Programming Languages course. I modified the code so it became a stand alone app, as Java Applets have become deprecated. In addition to implementing a new grammar at the request of Professor Wilkes , I also added features such as being able to rerun parsings during runtime and being able to choose a grammar from a drop down menu.

To use simply compile all files and run the main class in ParsDemo.Java.

## New Features

Live load Algorithms (7/28/22) : You can now live load Algorithms via a drop down menu instead of restarting the program over and over.

Free Scrolling (7/29/22) : You can now click or drag the scrollbars without having to hover over the window to update the graphics. You can also do this while the parsing animation runs.

Unstable Graphics Fixed (7/29/22) : The graphics have been fixed so they aren't unstable on start or or upon resizing.

## Bugs

- Sometimes when switching between algorithms the scroll bar moves down a bit on start up.

## Proposed New Features

- Having the program read in file input in addition to a sentence to parse from the text field.
- The ability to rewind a Parse with a Rewind Button.
- Implement the ANSI C Grammar(LALR(1)) for parsing C code.

## Folder Structure

The workspace contains two folders by default, where:

- `src`: the folder to maintain sources
- `lib`: the folder to maintain dependencies

Meanwhile, the compiled output files will be generated in the `bin` folder by default.


# 2024 Version

## Completed 

* Removed depricated code and replaced it with modern versions


* Made the screen size adjustible and adaptable for all screen sizes


* Fixed bug causing SR Parser to crash




## Incomplete Work
 
B-Minor has not been completely intergrated, the scanner &  grammar have been added but work still needs to be done to connect the scanner and grammar to the front end and to create the table and tree. 
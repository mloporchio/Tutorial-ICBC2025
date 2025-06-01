#
#		File:		makefile
#		Author:		Matteo Loporchio
#
#		This is a standard makefile to compile the entire project.
#		It compiles all the .java files in the current directory into .class files.
#		Many thanks to https://www.cs.swarthmore.edu/~newhall/unixhelp/javamakefiles.html for sharing their code.
#

JC = javac
OUTPUT_DIR = bin
.SUFFIXES: .java .class
.java.class:
	$(JC) -d $(OUTPUT_DIR) $*.java

CLASSES = \
	Geometry.java \
	Hash.java \
	MRTree.java \
	MRTreeNode.java \
	Pair.java \
	Point.java \
	Query.java \
	Rectangle.java \
	Test.java \
	Utility.java \
	VContainer.java \
	VLeaf.java \
	VObject.java \
	VPruned.java \
	VResult.java

default: classes

classes: $(CLASSES:.java=.class)

clean:
	$(RM) $(OUTPUT_DIR)/*.class

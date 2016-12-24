.SUFFIXES: .java .class
.java.class:
	javac -cp ./Acme.jar:./objectdraw.jar:. $<

run: MyController.class
	java -cp ./Acme.jar:./objectdraw.jar:. MyController

clean:
	rm -f *.class

new:
	make clean
	make run

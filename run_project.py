# runs maven commands and driver class
import os

def main():
        os.system('mvn clean compile assembly:single')
        os.system('java -cp target/thread_assignment-1.0-SNAPSHOT-jar-with-dependencies com.mca.assemblyline.main.Driver')
main()
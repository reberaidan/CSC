"""
Name: Aidan Weinreber
Date: 1/4/22
Assignment: TCP Server to Client code. This code opens a server for clients to connect to 
            and access html files in the directory.
"""

from socket import *

server_socket = socket(AF_INET, SOCK_STREAM)
server_socket.bind(('',12000))
server_socket.listen(1)
print("The server is ready to receive... \n")

while(True):
    """The connection between server and client is made. 
    The message is received and decoded"""
    connection_socket, address = server_socket.accept()
    message = connection_socket.recv(2048)
    modified_message = message.decode()

    """The message is split to allow for access later. 
    The server then prints the request"""
    modified_mess = modified_message.split()
    print("HTTP request: ")
    print(modified_message)
    print()

    """If the client properly sent a GET request
    then an attempt will be made to send the requested file"""
    if(modified_mess[0]=="GET"):
        print("Object to be fetched: {}".format(modified_mess[1][1:]))
        response = ""
        HTMLfile = modified_mess[1][1:]
        try:
            """Provided that the file exists, the server will read the file
            and send the result to the client"""
            f = open(HTMLfile, "r")
            HTMLres = f.read()
            print("Object content: ")
            print(HTMLres + "\n")
            response += "HTTP/1.1 200 OK\n\n" + HTMLres
            print("HTTP response message:\n" + response)
        except:
            """If the file does not exist, a 404 message will be sent."""
            response += "HTTP/1.1 404 Not Found"
            print("HTTP response message:\n" + response + "\n")
            
        """The server will send the proper response to the client."""
        connection_socket.send(response.encode())

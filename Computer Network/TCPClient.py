"""
Name: Aidan Weinreber
Date: 1/4/22
Assignment: Program that retreives files from server"""
from socket import *
from sys import argv

client_socket = socket(AF_INET, SOCK_STREAM)

"""Check to ensure that the correct number of variables are given"""
if(len(argv) == 4):
    """Pulls the server ip and port and connects with a client socket"""
    server_ip = argv[1]
    server_port = argv[2]
    client_socket.connect((server_ip, int(server_port)))
    
    """Prints off the command and the server it is connecting to"""
    print("HTTP request to server: ")
    print("GET /" + str(argv[3]) + " HTTP/1.1")
    print("Host: " + server_ip+ "\n")

    """Compiles and sends message to server"""
    message = "GET /" + str(argv[3]) + " HTTP/1.1 \nHost: " + server_ip
    client_socket.send(message.encode())

    """Received message from server and provides it to client."""
    received_message = client_socket.recv(2048)
    print("HTTP response from server: ")
    print(received_message.decode())
    print()

else:
    print("Incorrect commands given")
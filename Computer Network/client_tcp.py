from socket import *

client_socket = socket(AF_INET, SOCK_STREAM)

server_ip = input("server IP: ")
server_port = input("server port: ")

client_socket.connect((server_ip, int(server_port)))
print("connection is established")

message = input("Message: ")

client_socket.send(message.encode())
print("mess sent")

received_message = client_socket.recv(2048)
print("received message: {}".format(received_message.decode()))

client_socket.close()

from socket import *

server_socket = socket(AF_INET, SOCK_STREAM)
server_socket.bind(('', 12000))
server_socket.listen(1)
print("server is ready to connect...\n")

while(True):
    connection_socket,address = server_socket.accept()
    print("connection established with client: {}".format(address))

    incoming_message = connection_socket.recv(2048)
    print("receive message: {}".format(incoming_message.decode()))

    modified_message = incoming_message.upper()
    print("mod mes: {}".format(modified_message.decode()))

    connection_socket.send(modified_message)
    print("message sent...\n")

    connection_socket.close

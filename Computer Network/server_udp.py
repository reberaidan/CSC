from socket import *

server_socket = socket(AF_INET, SOCK_DGRAM)
server_socket.bind(('',12000))
print("Server is ready to receive")

while(True):
    message, client_address = server_socket.recvfrom(2048)
    print("Messge: {}\nFrom client: {}".format(message.decode(), client_address))

    modified_message = message.upper()
    print("mod message: {}".format(modified_message.decode()))

    server_socket.sendto(modified_message, client_address)
    print("message sent")

from socket import *

client_socket = socket(AF_INET, SOCK_DGRAM)

print("Socket has been created")

server_ip = input("Server IP: ")
server_port = input("Server Port: ")
message = input("message: ")

client_socket.sendto(message.encode(), (server_ip,int(server_port)))
print("\nSent message: {}]nTo sever: {}".format(message, (server_ip,int(server_port))))

recv_message,server_address = client_socket.recvfrom(2048)
print("Received Message: {}\nFromserver: {}".format(recv_message.decode,server_address))

client_socket.close()

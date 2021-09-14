######################################################################################################################
# Name: 
# Date: 
# Description: 
######################################################################################################################
from tkinter import *
from random import randint
# the 2D point class
class Point:
    #constructors
    def __init__(self, x = float(0), y = float(0)):
        self.x = float(x)
        self.y = float(y)
    #getters
    @property
    def x(self):
        return self._x

    @property
    def y(self):
        return self._y
    #setters
    @x.setter
    def x(self, value):
        self._x = value

    @y.setter
    def y(self, value):
        self._y = value

    #displays the point in (x,y) form
    def __str__(self):
        return "({},{})".format(self.x,self.y)

    #determines the distance between two points
    def dist(self, point):
        xdist = self.x - point.x
        ydist = self.y - point.y
        dist = (ydist**2) + (xdist**2)
        dist = (dist**0.5)
        return "{}".format(dist)
    #determines what the midpoint of two points are
    def midpt(self, point):
        if (point.x >= self.x):
            newx = (point.x - self.x)/2
        else:
            newx = (self.x - point.x)/2
        if (point.y >= self.y):
            newy = (point.y - self.y)/2
        else:
            newy = (self.y - point.y)/2
        #returns point as point class in case it is madea future point
        return Point(newx,newy)
	

# the coordinate system class: (0,0) is in the top-left corner
# inherits from the Canvas class of Tkinter
class CoordinateSystem(Canvas):

    radius = 0
    color = randint(0,6)
    def __init__(self, window):
        Canvas.__init__(self, window)

    def plotPoints(self, number):
        for i in (0, number+1):
            x = randint(0,800)
            y = randint(0,800)
            p = Point(x,y)
            Canvas.create_oval(p.x, p.y, self.radius, fill = self.Color(self.color))

    def Color(self,number):
        if(number == 0):
            return "black"
        elif(number == 1):
            return "red"
        elif(number == 2):
            return "green"
        elif(number == 3):
            return "blue"
        elif(number == 4):
            return "cyan"
        elif(number == 5):
            return "yellow"
        elif(number == 6):
            return "magenta"        
	# write your code for the coordinate system class here (and subsequently remove this comment)

##########################################################
# ***DO NOT MODIFY OR REMOVE ANYTHING BELOW THIS POINT!***
# the default size of the canvas is 800x800
WIDTH = 800
HEIGHT = 800
# the number of points to plot
NUM_POINTS = 5000

# create the window
window = Tk()
window.geometry("{}x{}".format(WIDTH, HEIGHT))
window.title("2D Points...Plotted")
# create the coordinate system as a Tkinter canvas inside the window
s = CoordinateSystem(window)
# plot some random points
s.plotPoints(NUM_POINTS)
# wait for the window to close
window.mainloop()

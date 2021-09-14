######################################################################################################################
# Name: Aidan Weinreber
# Date: 3/21/21
# Description: A function that places 2D dots on a plane, being able
#               to have the midpoint and distance between dots 
######################################################################################################################

# the 2D point class
class Point():
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
        
##########################################################
# ***DO NOT MODIFY OR REMOVE ANYTHING BELOW THIS POINT!***
# create some points
p1 = Point()
p2 = Point(3, 0)
p3 = Point(3, 4)
# display them
print("p1:", p1)
print("p2:", p2)
print("p3:", p3)
# calculate and display some distances
print("distance from p1 to p2:", p1.dist(p2))
print("distance from p2 to p3:", p2.dist(p3))
print("distance from p1 to p3:", p1.dist(p3))
# calculate and display some midpoints
print("midpt of p1 and p2:", p1.midpt(p2))
print("midpt of p2 and p3:", p2.midpt(p3))
print("midpt of p1 and p3:", p1.midpt(p3))
# just a few more things...
p4 = p1.midpt(p3)
print("p4:", p4)
print("distance from p4 to p1:", p4.dist(p1))

import pygame, random, math

# Grid
def create_grid():
    white_circles = []
    for i in range(circles_number - circles_offset):
        circles_ypos = circles_ystart + (circles_margin * i)

        if i % 2 == 0:
            white_circles.append(pygame.Rect(circles_xstart - circles_radius, circles_ypos - circles_radius, circles_radius * 2, circles_radius * 2))

            for j in range(1, i + 1 + circles_offset):
                circles_one_side = (i + circles_offset) / 2
                if j <= circles_one_side:
                    circle_xpos = circles_xstart - (circles_margin * j)
                else:
                    circle_xpos = circles_xstart + (circles_margin * (j - circles_one_side))

                white_circles.append(pygame.Rect(circle_xpos - circles_radius, circles_ypos - circles_radius, circles_radius * 2, circles_radius * 2))
        else:
            circles_xmargin = circles_margin / 2
            for j in range(1, i + 2 + circles_offset):
                circles_one_side = (i + 1 + circles_offset) / 2
                if j <= circles_one_side:
                    if j == 1:
                        circle_xpos = circles_xstart - circles_xmargin
                    else:
                        circle_xpos = circles_xstart - (circles_margin * j) + circles_xmargin
                else:
                    if j == circles_one_side + 1:
                        circle_xpos = circles_xstart + circles_xmargin
                    else:
                        circle_xpos = circles_xstart + (circles_margin * (j - circles_one_side)) - circles_xmargin

                white_circles.append(pygame.Rect(circle_xpos - circles_radius, circles_ypos - circles_radius, circles_radius * 2, circles_radius * 2))
    
    return white_circles

def draw_grid(white_circles):
    for circle in white_circles:
        pygame.draw.circle(screen, "White", circle.center, circles_radius)

# Init
screen_size = (1800, 900)

pygame.init()
screen = pygame.display.set_mode(screen_size)
pygame.display.set_caption("Plinko")
clock = pygame.time.Clock()
FPS = 60
running = True


circles_radius = 7
circles_number = 18
circles_offset = 2
circles_xstart = screen_size[0]/2
circles_ystart = 100

circles_margin = circles_radius * 6

# Class Ball
class Ball:
    balls = []
    timeout = 0

    def __init__(self):
        self.radius = circles_radius * 1.5
        self.x = circles_xstart
        self.y = 50
        self.diameter = self.radius * 2
        self.speed = 100 / FPS

        Ball.balls.append(self)
        Ball.timeout = 0

    def collide(self, circle):
        if math.hypot(self.x - circle.centerx, self.y - circle.centery) <= self.radius + circles_radius:
            return True
        else:
            return False
        
    def get_random_movement(self):
        center = screen_size[0] / 2
        bias = 0.65

        if self.x < center:
            return -self.diameter if random.random() < bias else self.diameter
        elif self.x > center:
            return self.diameter if random.random() < bias else -self.diameter
        else:
            return -self.diameter if random.gauss(0, 1) < 0 else self.diameter

    def update(self):
        self.y += self.speed

        for circle in white_circles:
            if self.collide(circle):
                self.x += self.get_random_movement()
                break

        pygame.draw.circle(screen, "Blue", (self.x, self.y), self.radius)
    
    def destroy(self):
        Ball.balls.remove(self)

# Game
white_circles = create_grid()

while running:
    for event in pygame.event.get():
        if event.type == pygame.QUIT:
            running = False
        elif event.type == pygame.KEYDOWN:
            if event.key == pygame.K_b and Ball.timeout > 0.2:
                ball = Ball()
            
    for ball in Ball.balls:
        if ball.y > 770:
            ball.destroy()

    screen.fill((0,0,0))
    draw_grid(white_circles)
    
    for ball in Ball.balls:
        ball.update()
    
    Ball.timeout += 1 / FPS

    pygame.display.update()
    clock.tick(FPS)

pygame.quit()
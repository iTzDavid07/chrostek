import pygame

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

for i in range(circles_number - circles_offset):
    circles_ypos = circles_ystart + (circles_margin * i)
    
    if i % 2 == 0:
        pygame.draw.circle(screen, "White", (circles_xstart, circles_ypos), circles_radius)

        for j in range(1, i+1 + circles_offset):
            circles_one_side = (i + circles_offset) / 2
            if j <= circles_one_side:
                circle_xpos = circles_xstart - (circles_margin * j)
            else:
                circle_xpos = circles_xstart + (circles_margin * (j - circles_one_side))
            
            pygame.draw.circle(screen, "White", (circle_xpos, circles_ypos), circles_radius)
    else:
        circles_xmargin = circles_margin / 2
        for j in range(1, i+2 + circles_offset):
            circles_one_side = (i+1 + circles_offset) / 2
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
            
            pygame.draw.circle(screen, "White", (circle_xpos, circles_ypos), circles_radius)

ball_speed = 30 / FPS
ball = pygame.draw.circle(screen, "Blue", (circles_xstart, 50), circles_radius * 2)

while running:
    for event in pygame.event.get():
        if event.type == pygame.QUIT:
            running = False

    ball.y += ball_speed

    pygame.display.update()
    clock.tick(FPS)

pygame.quit()
#ifndef _LINE_H_
#define _LINE_H_

#include <iostream>
#include <SFML/Graphics.hpp>
#include "Point.h"

#define LOG(x) std::cout << x << std::endl


class Line : public sf::Drawable
{
public:
    Line(Point* p1, Point* p2);
    ~Line();
    void update(sf::Window& window);

private:
    void draw(sf::RenderTarget& target, sf::RenderStates states) const;

    Point* m_p1;
    Point* m_p2;
    sf::Vertex m_line[2];
};


#endif // !_LINE_H_
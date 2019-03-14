#ifndef _POINT_H_
#define _POINT_H_

#include <iostream>
#include <SFML/Graphics.hpp>

#define LOG(x) std::cout << x << std::endl

#define RADIUS 2
#define OUTLINE_RADIUS 8

class Point : public sf::Drawable
{
public:
    Point(sf::Vector2f pos);
    ~Point();
    void update(sf::Window& window);
    void setPosition(sf::Vector2f newPos);
    void showOutline();
    void hideOutline();
    bool pointIn(sf::Vector2f p);
    sf::Vector2f getPosition() const;

    static bool dragging;
    
private:
    void draw(sf::RenderTarget& target, sf::RenderStates states) const;

    sf::Vector2f m_position;
    sf::CircleShape m_point;
    sf::CircleShape m_outline;

    bool m_isOutlineDrawed;

    bool m_dragAndDrop;

};


#endif // !_POINT_H_
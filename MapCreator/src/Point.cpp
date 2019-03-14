#include "Point.h"

bool Point::dragging = false;

Point::Point(sf::Vector2f pos) :
    m_position(pos),
    m_isOutlineDrawed(false),
    m_dragAndDrop(false)
{
    m_point.setRadius(RADIUS);
    m_point.setPosition(m_position.x - RADIUS, m_position.y - RADIUS);
    m_point.setFillColor(sf::Color::White);

    m_outline.setRadius(OUTLINE_RADIUS);
    m_outline.setPosition(m_position.x - OUTLINE_RADIUS, m_position.y - OUTLINE_RADIUS);
    m_outline.setFillColor(sf::Color::Transparent);
    m_outline.setOutlineColor(sf::Color::Red);
    m_outline.setOutlineThickness(2);
}

Point::~Point()
{
}

void Point::update(sf::Window& window)
{
    if(pointIn(sf::Vector2f(sf::Mouse::getPosition(window))))
    {
        showOutline();
        if(sf::Mouse::isButtonPressed(sf::Mouse::Left) && !m_dragAndDrop && !dragging)
        {
            m_dragAndDrop = true;
            dragging = true;
        }
    }
    else
    {
        hideOutline();
    }

    if(sf::Mouse::isButtonPressed(sf::Mouse::Left) && m_dragAndDrop)
    {
        setPosition(sf::Vector2f(sf::Mouse::getPosition(window)));
    }
    else if(!sf::Mouse::isButtonPressed(sf::Mouse::Left) && m_dragAndDrop)
    {
        dragging = false;
        m_dragAndDrop = false;
    }
}

void Point::setPosition(sf::Vector2f newPos)
{
    m_position = newPos;
    m_point.setPosition(m_position.x - m_point.getRadius(), m_position.y - m_point.getRadius());
    m_outline.setPosition(m_position.x - m_outline.getRadius(), m_position.y - m_outline.getRadius());
}

void Point::showOutline()
{
    m_isOutlineDrawed = true;
}

void Point::hideOutline()
{
    m_isOutlineDrawed = false;
}

bool Point::pointIn(sf::Vector2f p)
{
    float r = m_outline.getRadius();
    return(p.x > m_position.x - r
            && p.x < m_position.x + r
            && p.y > m_position.y - r
            && p.y < m_position.y + r);
}

sf::Vector2f Point::getPosition() const
{
    return m_position;
}

void Point::draw(sf::RenderTarget& target, sf::RenderStates states) const
{
    target.draw(m_point, states);
    if(m_isOutlineDrawed)
    {
        target.draw(m_outline, states);
    }
}
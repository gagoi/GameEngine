#include "Line.h"

Line::Line(Point* p1, Point* p2) :
    m_p1(p1),
    m_p2(p2)
{
    m_line[0] = sf::Vertex(p1->getPosition());
    m_line[1] = sf::Vertex(p2->getPosition());
}

Line::~Line()
{
}

void Line::update(sf::Window& window)
{
    m_line[0] = sf::Vertex(m_p1->getPosition());
    m_line[1] = sf::Vertex(m_p2->getPosition());
}

void Line::draw(sf::RenderTarget& target, sf::RenderStates states) const
{
    target.draw(m_line, 2, sf::Lines, states);
}

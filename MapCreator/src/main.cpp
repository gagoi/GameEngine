#include <SFML/Graphics.hpp>
#include <iostream>
#include "Point.h"
#include "Line.h"

int main()
{
	sf::RenderWindow window(sf::VideoMode(500, 500), "SFML works!");
	sf::RectangleShape shape(sf::Vector2f(100.f, 100.f));
	//shape.setFillColor(sf::Color::Green);
	//shape.setPosition(sf::Vector2f(100.f, 100.f));

	sf::View view;
	view.setSize(500.f, 500.f);
	view.setCenter(250.f, 250.f);

	Point* p1 = new Point(sf::Vector2f(100.f, 100.f));
	Point* p2 = new Point(sf::Vector2f(167.f, 284.f));

	Line* l = new Line(p1, p2);

	while (window.isOpen())
	{
		sf::Event event;
		while (window.pollEvent(event))
		{
			if (event.type == sf::Event::Closed)
				window.close();
			else if (event.type == sf::Event::MouseWheelScrolled)
			{
				if (event.mouseWheelScroll.delta < 0)
					view.zoom(0.9);
				else if (event.mouseWheelScroll.delta > 0)
					view.zoom(1.1);

			}
		}

		if (sf::Keyboard::isKeyPressed(sf::Keyboard::Left))
		{
			view.move(0.1, 0);
		}
		else if (sf::Keyboard::isKeyPressed(sf::Keyboard::Right))
		{
			view.move(-0.1, 0);
		}
		else if (sf::Keyboard::isKeyPressed(sf::Keyboard::Up))
		{
			view.move(0, 0.1);
		}
		else if (sf::Keyboard::isKeyPressed(sf::Keyboard::Down))
		{
			view.move(0, -0.1);
		}

		p1->update(window);
		p2->update(window);
		l->update(window);

		window.clear();

		window.setView(view);
		//window.draw(shape);
		window.draw(*p1);
		window.draw(*p2);
		window.draw(*l);

		window.display();
	}

	return 0;
}
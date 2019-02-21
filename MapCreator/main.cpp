#include <SFML/Graphics.hpp>

int main()
{
	sf::RenderWindow window(sf::VideoMode(500, 500), "SFML works!");
	sf::RectangleShape shape(sf::Vector2f(100.f, 100.f));
	shape.setFillColor(sf::Color::Green);
	shape.setPosition(sf::Vector2f(100.f, 100.f));

	sf::View view;
	view.setSize(500.f, 500.f);
	view.setCenter(250.f, 250.f);


	while (window.isOpen())
	{
		sf::Event event;
		while (window.pollEvent(event))
		{
			if (event.type == sf::Event::Closed)
				window.close();
		}

		if (sf::Keyboard::isKeyPressed(sf::Keyboard::Left))
		{
			view.move(-0.1, 0);
		}
		else if (sf::Keyboard::isKeyPressed(sf::Keyboard::Right))
		{
			view.move(0.1, 0);
		}
		else if (sf::Keyboard::isKeyPressed(sf::Keyboard::Up))
		{
			view.move(0, -0.1);
		}
		else if (sf::Keyboard::isKeyPressed(sf::Keyboard::Down))
		{
			view.move(0, 0.1);
		}


		window.clear();

		window.setView(view);
		window.draw(shape);

		window.display();
	}

	return 0;
}
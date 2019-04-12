# Zadanie 1

Program mający za zadanie wyznaczyć minimalną możliwą ilość toreb, potrzebynch do spakowania zadanych produktów i pokazania,
w której torbie powinien znaleźć się każdy artykuł.

Danymi wejściowymi są: wytrzymałość pojedynczej torby na zakupy oraz ID produktów które mają zostać spakowane.

Po zbudowaniu projektu, należy w klasie "AppRunner" wprowadzić wybrane dane bagLoad --> wytrzymałość siatki,
ID --> ID produktów do spakowania. Następnie uruchomić ww. klasę.

W projekcie znajduje się seria testów jednostkowych, zawartych w klasie "AlgorithmTest".

Aby kod mógł zostać wykorzystany w zewnętrznej aplikacji, zalecane będzie stworzenie funkcji, która dodatkowo zczytuje podane w pliku txt/cvs dane do kolejnych zamówień i je wydziela, tak by każde zamówienie było osobno obsługiwane. Jednocześnie powinna pytać o rodzaj/wytrzymałość użytych toreb.
Kolejnym wymaganym elementem, będzie funkcja odpowiedzialna za dostarczenie ścieżki, do ww. pliku z którego będą zczytywane dane.

# Zadanie 2

Skonstruowane założenia są wystarczające do orientacyjnego określenia ilości potrzebnych toreb. Umieszczenie dodatkowej danej informującej o
objętości/wielkości produktu, np. procentowej części pojemności torby zaokrąglonej w górę, dałoby w wyniku mnie sytuacji, gdzie siatka
może jeszcze mieć zapas wytrzymałości ciężaru, ale nic już do niej nie zmieścimy. 

Złożoność obliczeń wzrosła by nieznacznie, zakładając że system ten obsługuje klientów indywidualnych, tj. nie dostarcza ilości hurtowych 
dla pojedynczego klienta, czas pracy programu nie wydłużyłby się znacząco, a obliczenia związane z wydatkami byłyby bardziej na korzyść firmy.
Byłoby mniej sytuacji, gdzie pomimo wyliczenia X potrzebnych toreb, osoba pakująca musiała użyć X+Y tych toreb, za które klient nie byłby zobligowany zapłacić, 
ponieważ wcześniej przedstawione mu wyliczenia kosztów, ich nie obejmowały.

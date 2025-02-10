import requests
from bs4 import BeautifulSoup


def getsoup(url:str):
    try:
        response = requests.get(url)
        response.raise_for_status()  
        return BeautifulSoup(response.text, "html.parser")
    except requests.RequestException as e:
        print(f"Erreur lors de la récupération de la page: {e}")
        return None
    
    


class NonValid(Exception):
    def __init__(self,message="annonce non valide"):
        super().__init__(message)  

def prix(soup: BeautifulSoup) -> str:
    
    
    price_element=soup.find(class_="product-price fs-3 fw-bold")
    
    if not price_element:
        raise NonValid("Prix non trouvé sur la page.")
    
    # Extraction et nettoyage du prix
    price_text = price_element.get_text(strip=True).replace(" ", "").replace("€", "")
    try:
        price_value = int(price_text)
    except ValueError:
        raise NonValid("Prix invalide.")
    
    if price_value < 10000:
        raise NonValid("Prix trop bas, probablement une annonce non valide.")

    return str(price_value)


def ville(soup: BeautifulSoup) -> str:
    
    
    ville_element=soup.find(class_="mt-0")
    
    if not ville_element:
        raise NonValid("Prix non trouvé sur la page.")
    
    # Extraction et nettoyage du prix
    ville_text = ville_element.get_text(strip=True).replace(" ", "")
    ville_text=ville_text[ville_text.rfind(",")+1:]
    if not ville_text:
        raise NonValid("Ville non trouvé sur la page.")
    
    return ville_text

def details(soup: BeautifulSoup) -> BeautifulSoup:
    details=soup.find(class_="list-inline row col-12 gap-3")
    if not details:
        raise NonValid("Détails non trouvé sur la page.")
    return details

def type(soup):
    details_section=details(soup)
    li=details_section.find_all("li")
    for i in li:
        label = i.find("span", class_="text-muted")
        if label and label.text == "Type":
            value = i.find_all("span")[1]
            type = value.string.strip()
            if type:
                if type.lower() == "maison" or type.lower()=="appartement":
                    return type
    raise NonValid("no TYPE")

def surface(soup):
    details_section=details(soup)
    li=details_section.find_all("li")
    for i in li:
        label = i.find("span", class_="text-muted")
        if label and label.text == "Surface":
            value = i.find_all("span")[1]
            surface = value.string.strip()
            if surface:
                return surface[:-3]
            
    return "-"   

def nbrpieces(soup):
    details_section=details(soup)
    li=details_section.find_all("li")
    for i in li:
        label = i.find("span", class_="text-muted")
        if label and label.text == "Nb. de pièces":
            value = i.find_all("span")[1]
            nbrpc = value.string.strip()
            if nbrpc:
                return nbrpc
            
    return "-" 

def nbrchambres(soup):
    details_section=details(soup)
    li=details_section.find_all("li")
    for i in li:
        label = i.find("span", class_="text-muted")
        if label and label.text == "Nb. de chambres":
            value = i.find_all("span")[1]
            nbrchmbr = value.string.strip()
            if nbrchmbr:
                return nbrchmbr
            
    return "-" 

def nbrsdb(soup):
    details_section=details(soup)
    li=details_section.find_all("li")
    for i in li:
        label = i.find("span", class_="text-muted")
        if label and label.text == "Nb. de sales de bains":
            value = i.find_all("span")[1]
            nbrsdb = value.string.strip()
            if nbrsdb:
                return nbrsdb
            
    return "-" 


def dpe(soup):
    details_section=details(soup)
    li=details_section.find_all("li")
    for i in li:
        label = i.find("span", class_="text-muted")
        if label and label.text == "Consommation d'énergie (DPE)":
            value = i.find_all("span")[1]
            dpe = value.string.strip()
            if dpe:
                return dpe[0]
            
    return "-" 

def informations(soup):
    annonce=ville(soup)+","+ type(soup) +"," + surface(soup) +","+ nbrpieces(soup) +","+ nbrchambres(soup) +","+ nbrsdb(soup) +"," + dpe(soup) +","+ prix(soup)
    if annonce:
        return annonce
    else:
        raise NonValid("Non conforme")
    
    
    


url = "https://www.immo-entre-particuliers.com/annonces/france-ile-de-france/vente/ta-offer"
baseUrl="https://www.immo-entre-particuliers.com"
soup = getsoup(url)
# annonce_prix = prix(soup)
# print(annonce_prix)
# annonce_ville= ville(soup)
# print(annonce_ville)
#print(informations(soup))

def getDataPagesSize(soup):
    soupp = soup.find_all(class_="row products-pager")
    soupp = soupp[len(soupp) - 1]
    soupp = soupp.find_all("a")
    return int(soupp[len(soupp) - 2].text)


def getPageAnnonLink(soup):
    soupp = soup.find_all(class_="row product shadow p-2 rounded-3")
    # print(soupp)
    for i in soupp:
        link = i.find("a")
        soupLink=getsoup(baseUrl+ link.get("href"))
        AnnonceInfos=""
        try:
            AnnonceInfos=informations(soupLink)
            file.write(AnnonceInfos + "\n")

        except NonValid as e:
            AnnonceInfos=""
        #print(baseUrl+ link.get("href"))

nomPages=getDataPagesSize(soup)

with open("data.txt", "w") as file:
    file.write("Ville,Type,Surface,NbrPieces,NbrChambres,NbrSdb,DPE,Prix" + "\n")
    for i in range(1,nomPages+1):
        soup = getsoup(url+"/"+str(i))
        getPageAnnonLink(soup)
        

    

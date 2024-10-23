import os
import xml.etree.ElementTree as ET
import subprocess

def encontrar_pom_xml(caminho_raiz):
    for root, dirs, files in os.walk(caminho_raiz):
        if 'pom.xml' in files:
            return os.path.join(root, 'pom.xml')
    return None

def obter_versao_atual(pom_path):
    tree = ET.parse(pom_path)
    root = tree.getroot()
    # Define o namespace do XML
    ns = {'maven': 'http://maven.apache.org/POM/4.0.0'}
    
    # Busca a tag de versão dentro do XML
    version_tag = root.find('maven:version', ns)
    if version_tag is not None:
        return version_tag.text
    else:
        return None

def executar_comando_maven(nova_versao):
    try:
        subprocess.run(["mvn", f"versions:set", f"-DnewVersion={nova_versao}"], check=True)
        print(f"Comando Maven executado com sucesso. Projeto atualizado para a versão {nova_versao}.")
    except subprocess.CalledProcessError as e:
        print(f"Erro ao executar o comando Maven: {e}")

if __name__ == "__main__":
    caminho_raiz = os.getcwd()
    pom_path = encontrar_pom_xml(caminho_raiz)

    if pom_path:
        print(f"Arquivo POM encontrado em: {pom_path}")
        versao_atual = obter_versao_atual(pom_path)
        
        if versao_atual:
            print(f"Versão atual do projeto: {versao_atual}")
            nova_versao = input("Digite a nova versão do projeto: ")
            executar_comando_maven(nova_versao)
        else:
            print("Não foi possível encontrar a versão atual do projeto.")
    else:
        print("Arquivo POM não encontrado.")

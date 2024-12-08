import xml.etree.ElementTree as ET
import json

# Lire le rapport Checkstyle (XML)
tree = ET.parse('target/site/checkstyle-result.xml')
root = tree.getroot()

# Variables pour suivre les erreurs
total_files = 0
files_with_errors = 0

# Parcourir les fichiers dans le rapport Checkstyle
for file in root.findall('file'):
    total_files += 1
    if file.find('error') is not None:
        files_with_errors += 1

# Calculer les données pour le badge
error_count = sum(1 for _ in root.iter('error'))
error_free_percentage = ((total_files - files_with_errors) / total_files) * 100 if total_files > 0 else 100

# Générer le JSON pour le badge
badge_data = {
    "schemaVersion": 1,
    "label": "Checkstyle",
    "message": f"{error_free_percentage:.1f}% | {error_count} errors",
    "color": "red" if error_count > 0 else "brightgreen"
}

# Sauvegarder le fichier JSON dans le dossier docs
with open('docs/checkstyle-badge.json', 'w') as json_file:
    json.dump(badge_data, json_file)

print("Badge JSON généré dans docs/checkstyle-badge.json")

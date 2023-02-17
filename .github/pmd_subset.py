import xml.etree.ElementTree as ET

ET.register_namespace('', 'http://pmd.sourceforge.net/report/2.0.0')
tree = ET.parse('TicketManager/target/pmd.xml')
root = tree.getroot()

desired_pmd_rules = ['JUnitTests', 'JUnit4Test', 'TestClass', 'Assertion', 'UseAssert']

for file in root.findall("{http://pmd.sourceforge.net/report/2.0.0}file"):
    # file represents violatoins in an individual Java file
	
	for violation in file.findall("{http://pmd.sourceforge.net/report/2.0.0}violation"):
		# violation is an individual violation of one of the PMD rules
		specific_rule_violated = violation.get('rule')
		#print(f"Rule is {specific_rule_violated}")
		matching = [rule for rule in desired_pmd_rules if rule in specific_rule_violated]
		if len(matching) == 0:
			#print(f"----> Matched against {matching}")
			file.remove(violation)


tree.write("TicketManager/target/junit_alerts.xml")
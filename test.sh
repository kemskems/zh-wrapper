#!/bin/bash

TW2CN=tests/tw2cn
CN2TW=tests/cn2tw

# Initialization
init() {
	if [ -e ZHMain.class ]; then
		rm ZHMain.class
	fi
	javac ZHMain.java
}

# Test traditional to simplified Chinese conversion
tw2cn_test() {
	echo -n "Testing zh-TW to zh-CN conversion... "
	java ZHMain zh-CN < $TW2CN/in > $TW2CN/tmp.out 2> /dev/null
	DIFF=`diff $TW2CN/out $TW2CN/tmp.out`
	if [ -z "$DIFF" ]; then
		echo "SUCCESS"
	else
		echo "FAILED!"
	fi
	rm $TW2CN/tmp.out
}

# Test simplified to traditional Chinese conversion
cn2tw_test() {
	echo -n "Testing zh-CN to zh-TW conversion... "
	java ZHMain zh-TW < $CN2TW/in > $CN2TW/tmp.out 2> /dev/null
	DIFF=`diff $CN2TW/out $CN2TW/tmp.out`
	if [ -z "$DIFF" ]; then
		echo "SUCCESS"
	else
		echo "FAILED!"
	fi
	rm $CN2TW/tmp.out
}

init
tw2cn_test
cn2tw_test

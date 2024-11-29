.PHONY: test

test: src/compare.py tests/test.py
	python3 -m unittest discover tests
	rm -rf src/__pycache__
	rm -rf tests/__pycache__

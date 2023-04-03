import sys
from transformers import pipeline

def main():
    if len(sys.argv) < 2:
        print("Usage: sentiment_analysis.py <text>")
        sys.exit(1)

    text = sys.argv[1]
    sentiment_pipeline = pipeline(
        "sentiment-analysis",
        model="distilbert-base-uncased-finetuned-sst-2-english",
        revision="af0f99b"
    )
    result = sentiment_pipeline(text)
    sentiment_score = result[0]["score"]
    print(sentiment_score)

if __name__ == "__main__":
    main()

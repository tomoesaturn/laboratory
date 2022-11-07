# %%
import pandas

train = pandas.read_csv("./train.csv")


# %%
from pycaret.classification import *

s = setup(
    train,
    target="Survived",
    ignore_features=["PassengerId", "Name", "Ticket", "Cabin"],
    numeric_features=["Age", "SibSp", "Parch", "Fare"],
    ordinal_features={
        "Pclass": ["3", "2", "1"],
        "Sex": ["male", "female"],
        "Embarked": ["S", "C", "Q"],
    },
)


# %%
best = compare_models()


# %%
evaluate_model(best)


# %%
test = pandas.read_csv("./test.csv")
predict = predict_model(best, test)


# %%
output = pd.DataFrame({"PassengerId": predict.PassengerId, "Survived": predict.Label})
output.to_csv("submission.csv", index=False)

# %%

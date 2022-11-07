# titanic

https://www.kaggle.com/competitions/titanic/overview

```
kaggle competitions submit -c titanic -f submission.csv -m $(date "+%Y%m%d")
```

## データ

カラム
- PassengerId: int >= 1
- Survived(to predict): bool
- Pclass: {1,2,3}, Ticket class
- Name: string
- Sex, bool
- Age, int? >= 0
- SibSp, int >= 0, # of siblings, spouses
- Parch, int >= 0, # of parents, children 
- Ticket, string, int, Ticket number
- Fare, float
- Cabin, {A-Z}int?
- Embarked: {S,C,Q}, Port of Embarkation(乗船地)

train.csvは890レコード
gender_submission.csvの形式(PassengerId,bool)のcsvを提出する。

Pclass, Sex, Embarkedは2,3値の離散的な値をとる
Ageは連続的な値で、非整数値、欠損値もある。
SibSp, Parchはlog的な分布を持つ。取りうる値は0~10程度の整数値。

## 戦略

Name, Ticket, Cabinは考慮の対象から外す。

データ数はそこまで多くなくて、離散的な値をとるデータが多いので、ノンパラメトリックな手法が有効そうである。

SibSp, Parchは2以下 / 3以上で2値に階級化すれば、データの特性を保ったまま分類できそう。

Ageは欠損値の取り扱いと、年齢の階級化をどうするかが問題。

fareはPclassと関係がありそうなので3階級くらいで分けると良さそう。ただし0だけは特別扱いして1つの階級にした方が良さそう。

[PyCaret](https://github.com/pycaret/pycaret)を使ってみる。



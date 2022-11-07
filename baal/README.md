# baal

My Kaggle Workpsace

## Development

create env

1. `pyton --version`
1. `poetry env use python`
1. `poetry shell`
1. `poetry install`
1. Set `~/.kaggle/kaggle.json` in order to enable kaggle API. 

delete env

1. `poetry env remove --all`

## Kaggle API

[Kaggle Public API Documentation](https://www.kaggle.com/docs/api#interacting-with-competitions)

```bash
kaggle competitions list

kaggle competitions download -c [COMPETITION]

kaggle competitions submit -c [COMPETITION] -f [FILE] -m [MESSAGE]
```

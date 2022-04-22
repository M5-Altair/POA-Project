package recette;

import error.NoIngredientException;
import error.PoolIngredientException;
import bonbon.PoolIngredient;
import operation.OperationBrasser;
import operation.OperationEmballer;
import operation.OperationPeser;

public class RecetteReglisse extends Recette {

    public RecetteReglisse() throws PoolIngredientException {
        super();
        //On choisit les ingrédients présents dans la recette
        PoolIngredient poolIngredient = PoolIngredient.getInstance();
        try {
            ingredients.put(
                    poolIngredient.PrendreIngredient(
                            poolIngredient.GetIngredient("Sucre"), 10
                    ).getKey(),
                    10);

            ingredients.put(
                    poolIngredient.PrendreIngredient(
                            poolIngredient.GetIngredient("Anis"), 10
                    ).getKey(),
                    10);

            ingredients.put(
                    poolIngredient.PrendreIngredient(
                            poolIngredient.GetIngredient("Gélatine"), 10
                    ).getKey(),
                    10);

        } catch (NoIngredientException exception) {
            System.out.println(exception);
        }
        //On fait la liste des opérations avec leurs ingrédients (si oui) et on les éxecutes
        operations.add(new OperationPeser(poolIngredient.GetIngredient("Sucre")));
        operations.add(new OperationBrasser());
        operations.add(new OperationEmballer());
    }
}

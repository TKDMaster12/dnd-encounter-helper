//triggered when modal is about to be shown
$('#hpModificationModal').on('show.bs.modal', function(e) {
    //Get data from class
    var combatantName = $(e.relatedTarget).data('combatant-name');
    var combatantCurrentHp = $(e.relatedTarget).data('combatant-current-hp');

    //populate the textbox
    $(e.currentTarget).find('input[id="combatant-name"]').val(combatantName);
    $(e.currentTarget).find('input[id="combatant-current-hp"]').val(combatantCurrentHp);
});
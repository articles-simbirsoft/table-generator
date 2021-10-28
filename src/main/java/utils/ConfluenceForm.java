package utils;

public interface ConfluenceForm {

    String TABLE_LINE = "<tr><td style=\"text-align: left;\"><strong>%s</strong></td><td style=\"text-align: left;\">%s</td>" +
            "<td style=\"text-align: center;\"><span style=\"color: rgb(23,43,77);\">%s</span><br /><br /><br /></td>" +
            "<td style=\"text-align: left;\"><p><span style=\"color: rgb(0,0,0);\">%s</span>&nbsp;<br />&nbsp;</p></td>" +
            "<td class=\"highlight-%s\" style=\"text-align: left;\" title=\"Цвет фона: %s\" data-highlight-colour=\"%s\">" +
            "<p title=\"\"><span style=\"color: rgb(23,43,77);\">%s</span></p></td><td style=\"text-align: left;\"><br /></td>" +
            "<td style=\"text-align: left;\"><br /></td><td style=\"text-align: left;\"><p><br /></p></td>" +
            "<td style=\"text-align: left;\"><p><br /></p></td><td style=\"text-align: left;\"><p><br /></p></td>" +
            "<td style=\"text-align: left;\"><p><br /></p></td></tr>";


    String TABLE_HEADER = "<p class=\"auto-cursor-target\"><br /></p><table class=\"relative-table\" style=\"width: 1746.2px;\">" +
            "<thead><tr><th class=\"highlight-red\" style=\"text-align: center;\" colspan=\"11\" data-highlight-colour=\"red\">" +
            "<p style=\"text-align: center;\" title=\"\"><span style=\"color: rgb(23,43,77);\">Прогон</span><strong style=\"text-align: center;\" title=\"\">" +
            "<span>&nbsp;</span>%s&nbsp;</strong></p><p style=\"text-align: center;\" title=\"\"><strong style=\"text-align: center;\" title=\"\">" +
            "Ссылка на отчет:<span>&nbsp;</span><a href=\"%s\" rel=\"nofollow\" style=\"\" class=\"external-link\">%s</a></strong></p></th></tr></thead>" +
            "<colgroup><col /><col style=\"width: 172.391px;\" /><col style=\"width: 172.391px;\" /><col style=\"width: 135.609px;\" />" +
            "<col style=\"width: 152.562px;\" /><col style=\"width: 118.203px;\" /><col style=\"width: 177.641px;\" /><col style=\"width: 167.125px;\" />" +
            "<col style=\"width: 163.625px;\" /><col style=\"width: 148.781px;\" /><col style=\"width: 150.391px;\" /><col style=\"width: 110.156px;\" /></colgroup>" +
            "<tbody><tr><th style=\"text-align: left;\">№</th><th style=\"text-align: left;\">Платформа</th><th style=\"text-align: center;\">Раздел</th>" +
            "<th style=\"text-align: center;\">Подраздел</th><th style=\"text-align: center;\">Кейс</th><th style=\"text-align: center;\">ФИО</th>" +
            "<th style=\"text-align: center;\" colspan=\"5\">Результат<br /><br /><br /><br /></th></tr>" +
            "<tr><td class=\"highlight-red\" style=\"text-align: left;\" rowspan=\"2\" data-highlight-colour=\"red\"><br /></td>" +
            "<td class=\"highlight-red\" style=\"text-align: left;\" rowspan=\"2\" data-highlight-colour=\"red\"><br /></td>" +
            "<td class=\"highlight-red\" style=\"text-align: center;\" rowspan=\"2\" data-highlight-colour=\"red\"><p title=\"\"><br />&nbsp;</p></td>" +
            "<td class=\"highlight-red\" style=\"text-align: center;\" rowspan=\"2\" data-highlight-colour=\"red\"><p title=\"\"><br />&nbsp;</p></td>" +
            "<td class=\"highlight-red\" style=\"text-align: center;\" rowspan=\"2\" data-highlight-colour=\"red\"><br /></td>" +
            "<td class=\"highlight-red\" style=\"text-align: center;\" rowspan=\"2\" data-highlight-colour=\"red\"><br /></td>" +
            "<td class=\"highlight-red\" style=\"text-align: center;\" rowspan=\"2\" data-highlight-colour=\"red\">" +
            "<span style=\"color: rgb(23,43,77);\" title=\"\">Кейс пройден руками</span></td><td class=\"highlight-red\" style=\"text-align: center;\" colspan=\"2\" data-highlight-colour=\"red\">" +
            "<span style=\"color: rgb(23,43,77);\" title=\"\">Баг</span></td><td class=\"highlight-red\" style=\"text-align: center;\" rowspan=\"2\" data-highlight-colour=\"red\">" +
            "<span style=\"color: rgb(23,43,77);\" title=\"\">блокирует проверку</span></td><td class=\"highlight-red\" style=\"text-align: center;\" rowspan=\"2\" data-highlight-colour=\"red\">" +
            "<span style=\"color: rgb(23,43,77);\" title=\"\">требуется доработка автотеста</span></td></tr><tr>" +
            "<td class=\"highlight-red\" style=\"text-align: center;\" data-highlight-colour=\"red\">в предыдущем прогоне</td>" +
            "<td class=\"highlight-red\" style=\"text-align: center;\" data-highlight-colour=\"red\">в текущем прогоне</td></tr>";

    String TABLE_TAIL = "</tbody></table><p class=\"auto-cursor-target\"><br /></p>";
}

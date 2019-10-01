select *
from hlt_SMTAP

select *
from hlt_disp_ExamSM
where rf_ExamGuid in
      (select guid from hlt_disp_Exam where rf_CardGuid = (select guid from hlt_disp_Card where disp_CardID = 2409))
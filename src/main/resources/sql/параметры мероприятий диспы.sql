
select *
from hlt_disp_service
where Name like '%Определение относительного суммарного сердечно-сосудистого риска%'

select *
from hlt_disp_serviceparam
where rf_ServiceGuid = '2BB6BA4B-DD4D-4FD5-8542-ED68AD79AE48'

select *
from oms_ParamGroupParam

select *
from oms_Param
where guid = '540F4BF0-03B2-4BA9-96CF-1C6F25EBB4D7'

select *
from oms_ParamGroup

select *
from hlt_disp_ExamParamValue

select *
from oms_ParamValue
--     ParamID таблицы oms_Param

--стандартные параметры мероприятия
select p.*
from hlt_disp_Service ds,
     hlt_disp_serviceparam dsp,
     oms_Param p
where ds.name like '%Определение относительного суммарного сердечно-сосудистого риска%'
  and dsp.rf_ServiceGuid = ds.Guid
  and p.guid = dsp.rf_OmsParamGuid
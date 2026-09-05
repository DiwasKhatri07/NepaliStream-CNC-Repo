package com.phisher98;

import com.lagradost.api.Log;
import com.lagradost.cloudstream3.MainActivityKt;
import com.lagradost.nicehttp.NiceResponse;
import com.lagradost.nicehttp.Requests;
import com.lagradost.nicehttp.ResponseParser;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;
import okhttp3.Interceptor;
import okhttp3.RequestBody;

/* JADX INFO: compiled from: UltimaSettingsSyncUtils.kt */
/* JADX INFO: loaded from: /home/ubuntu/work/NepaliStream-CNC-Repo/decoded/phisher98/Ultima/classes.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001*\u00020\u0004H\n"}, d2 = {"<anonymous>", "Lkotlin/Pair;", "Lcom/phisher98/SyncCategory;", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 4, 0}, xi = 48)
@DebugMetadata(c = "com.phisher98.UltimaSettingsSyncUtils$pushCategories$2$jobs$1$1", f = "UltimaSettingsSyncUtils.kt", i = {0, 0, 0}, l = {328}, m = "invokeSuspend", n = {"catUrl", "compressedData", "payload"}, nl = {329}, s = {"L$0", "L$1", "L$2"}, v = 2)
final class UltimaSettingsSyncUtils$pushCategories$2$jobs$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Pair<? extends SyncCategory, ? extends Boolean>>, Object> {
    final /* synthetic */ SyncCategory $category;
    final /* synthetic */ AppSettingsSyncCreds $creds;
    final /* synthetic */ Pair<String, String> $dataPair;
    final /* synthetic */ String $deviceName;
    final /* synthetic */ long $now;
    Object L$0;
    Object L$1;
    Object L$2;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    UltimaSettingsSyncUtils$pushCategories$2$jobs$1$1(AppSettingsSyncCreds appSettingsSyncCreds, SyncCategory syncCategory, Pair<String, String> pair, long j, String str, Continuation<? super UltimaSettingsSyncUtils$pushCategories$2$jobs$1$1> continuation) {
        super(2, continuation);
        this.$creds = appSettingsSyncCreds;
        this.$category = syncCategory;
        this.$dataPair = pair;
        this.$now = j;
        this.$deviceName = str;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new UltimaSettingsSyncUtils$pushCategories$2$jobs$1$1(this.$creds, this.$category, this.$dataPair, this.$now, this.$deviceName, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Pair<? extends SyncCategory, Boolean>> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        Object objPut$default;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        try {
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    String catUrl = this.$creds.getActiveUrl() + "sync/" + this.$creds.getSyncKey() + "/categories/" + this.$category.getKey() + ".json";
                    String compressedData = UltimaSettingsSyncUtils.INSTANCE.compressData((String) this.$dataPair.getFirst());
                    SyncCategoryPayload payload = new SyncCategoryPayload(compressedData, this.$now, this.$deviceName);
                    Log.INSTANCE.d("UltimaSync", "Push " + this.$category.getKey() + ": raw=" + ((String) this.$dataPair.getFirst()).length() + " chars, compressed=" + compressedData.length() + " chars");
                    this.L$0 = SpillingKt.nullOutSpilledVariable(catUrl);
                    this.L$1 = SpillingKt.nullOutSpilledVariable(compressedData);
                    this.L$2 = SpillingKt.nullOutSpilledVariable(payload);
                    this.label = 1;
                    objPut$default = Requests.put$default(MainActivityKt.getApp(), catUrl, (Map) null, (String) null, (Map) null, (Map) null, (Map) null, (List) null, payload, (RequestBody) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, (Continuation) this, 65406, (Object) null);
                    if (objPut$default == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    break;
                case 1:
                    ResultKt.throwOnFailure($result);
                    objPut$default = $result;
                    break;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            NiceResponse catRes = (NiceResponse) objPut$default;
            int code = catRes.getCode();
            if (200 <= code && code < 300) {
                return TuplesKt.to(this.$category, Boxing.boxBoolean(true));
            }
            Log.INSTANCE.e("UltimaSync", "pushCategories: " + this.$category.getKey() + " failed HTTP " + catRes.getCode() + ": " + StringsKt.take(catRes.getText(), 200));
            return TuplesKt.to(this.$category, Boxing.boxBoolean(false));
        } catch (Exception e) {
            Log.INSTANCE.e("UltimaSync", "pushCategories: " + this.$category.getKey() + " error: " + e.getMessage());
            return TuplesKt.to(this.$category, Boxing.boxBoolean(false));
        }
    }
}

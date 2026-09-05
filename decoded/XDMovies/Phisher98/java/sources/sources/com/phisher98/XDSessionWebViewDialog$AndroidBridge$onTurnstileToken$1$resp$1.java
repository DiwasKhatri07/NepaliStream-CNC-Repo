package com.phisher98;

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
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: XDSessionWebViewDialog.kt */
/* JADX INFO: loaded from: /home/runner/work/NepaliStream-CNC-Repo/NepaliStream-CNC-Repo/decoded/XDMovies/Phisher98/java/classes.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Lcom/lagradost/nicehttp/NiceResponse;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 4, 0}, xi = 48)
@DebugMetadata(c = "com.phisher98.XDSessionWebViewDialog$AndroidBridge$onTurnstileToken$1$resp$1", f = "XDSessionWebViewDialog.kt", i = {}, l = {87}, m = "invokeSuspend", n = {}, nl = {99}, s = {}, v = 2)
final class XDSessionWebViewDialog$AndroidBridge$onTurnstileToken$1$resp$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super NiceResponse>, Object> {
    final /* synthetic */ String $cookieHeader;
    final /* synthetic */ String $fp;
    final /* synthetic */ String $token;
    int label;
    final /* synthetic */ XDSessionWebViewDialog.AndroidBridge this$0;
    final /* synthetic */ XDSessionWebViewDialog this$1;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    XDSessionWebViewDialog$AndroidBridge$onTurnstileToken$1$resp$1(XDSessionWebViewDialog.AndroidBridge androidBridge, XDSessionWebViewDialog xDSessionWebViewDialog, String str, String str2, String str3, Continuation<? super XDSessionWebViewDialog$AndroidBridge$onTurnstileToken$1$resp$1> continuation) {
        super(2, continuation);
        this.this$0 = androidBridge;
        this.this$1 = xDSessionWebViewDialog;
        this.$cookieHeader = str;
        this.$fp = str2;
        this.$token = str3;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new XDSessionWebViewDialog$AndroidBridge$onTurnstileToken$1$resp$1(this.this$0, this.this$1, this.$cookieHeader, this.$fp, this.$token, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super NiceResponse> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) throws JSONException {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                Requests isolatedApp = this.this$0.getIsolatedApp();
                String str = this.this$1.baseUrl + "/api/session/complete";
                RequestBody.Companion companion = RequestBody.Companion;
                JSONObject $this$invokeSuspend_u24lambda_u240 = new JSONObject();
                String str2 = this.$fp;
                String str3 = this.$token;
                $this$invokeSuspend_u24lambda_u240.put("fingerprint", str2);
                $this$invokeSuspend_u24lambda_u240.put("turnstileToken", str3);
                RequestBody requestBodyCreate = companion.create($this$invokeSuspend_u24lambda_u240.toString(), MediaType.Companion.get("application/json"));
                Pair[] pairArr = {TuplesKt.to("Content-Type", "application/json"), TuplesKt.to("Origin", this.this$1.baseUrl), TuplesKt.to("Referer", this.this$1.baseUrl), TuplesKt.to("Cookie", this.$cookieHeader)};
                this.label = 1;
                Object objPost$default = Requests.post$default(isolatedApp, str, MapsKt.mapOf(pairArr), (String) null, (Map) null, (Map) null, (Map) null, (List) null, (Object) null, requestBodyCreate, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, (Continuation) this, 65276, (Object) null);
                return objPost$default == coroutine_suspended ? coroutine_suspended : objPost$default;
            case 1:
                ResultKt.throwOnFailure($result);
                return $result;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}

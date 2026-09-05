package com.phisher98;

import com.lagradost.cloudstream3.MainActivityKt;
import com.lagradost.nicehttp.NiceResponse;
import com.lagradost.nicehttp.Requests;
import com.lagradost.nicehttp.ResponseParser;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.RequestBody;

/* JADX INFO: compiled from: Jellyfin.kt */
/* JADX INFO: loaded from: /home/runner/work/NepaliStream-CNC-Repo/NepaliStream-CNC-Repo/decoded/Jellyfin/Phisher98/java/classes.dex */
@Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001H\n"}, d2 = {"<anonymous>", "Lcom/phisher98/LoadURL;"}, k = 3, mv = {2, 4, 0}, xi = 48)
@DebugMetadata(c = "com.phisher98.Jellyfin$fetchPlaybackInfo$2$response$1", f = "Jellyfin.kt", i = {}, l = {249}, m = "invokeSuspend", n = {}, nl = {250}, s = {}, v = 2)
@SourceDebugExtension({"SMAP\nJellyfin.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Jellyfin.kt\ncom/phisher98/Jellyfin$fetchPlaybackInfo$2$response$1\n+ 2 NiceResponse.kt\ncom/lagradost/nicehttp/NiceResponse\n*L\n1#1,301:1\n73#2,5:302\n*S KotlinDebug\n*F\n+ 1 Jellyfin.kt\ncom/phisher98/Jellyfin$fetchPlaybackInfo$2$response$1\n*L\n250#1:302,5\n*E\n"})
final class Jellyfin$fetchPlaybackInfo$2$response$1 extends SuspendLambda implements Function1<Continuation<? super LoadURL>, Object> {
    final /* synthetic */ String $apiUrl;
    final /* synthetic */ String $body;
    final /* synthetic */ Map<String, String> $headers;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    Jellyfin$fetchPlaybackInfo$2$response$1(String str, Map<String, String> map, String str2, Continuation<? super Jellyfin$fetchPlaybackInfo$2$response$1> continuation) {
        super(1, continuation);
        this.$apiUrl = str;
        this.$headers = map;
        this.$body = str2;
    }

    public final Continuation<Unit> create(Continuation<?> continuation) {
        return new Jellyfin$fetchPlaybackInfo$2$response$1(this.$apiUrl, this.$headers, this.$body, continuation);
    }

    public final Object invoke(Continuation<? super LoadURL> continuation) {
        return create(continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        Object objPost$default;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                this.label = 1;
                objPost$default = Requests.post$default(MainActivityKt.getApp(), this.$apiUrl, this.$headers, (String) null, (Map) null, (Map) null, (Map) null, (List) null, (Object) null, RequestBody.Companion.create(this.$body, MediaType.Companion.get("application/json")), false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, (Continuation) this, 65276, (Object) null);
                if (objPost$default == coroutine_suspended) {
                    return coroutine_suspended;
                }
                break;
            case 1:
                ResultKt.throwOnFailure($result);
                objPost$default = $result;
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        NiceResponse this_$iv = (NiceResponse) objPost$default;
        try {
            ResponseParser parser = this_$iv.getParser();
            Intrinsics.checkNotNull(parser);
            return parser.parseSafe(this_$iv.getText(), Reflection.getOrCreateKotlinClass(LoadURL.class));
        } catch (Exception e$iv) {
            e$iv.printStackTrace();
            return null;
        }
    }
}

package com.layarKacaProvider;

import com.lagradost.api.Log;
import com.lagradost.cloudstream3.MainActivityKt;
import com.lagradost.cloudstream3.SubtitleFile;
import com.lagradost.cloudstream3.utils.ExtractorApi;
import com.lagradost.cloudstream3.utils.ExtractorLink;
import com.lagradost.cloudstream3.utils.M3u8Helper;
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
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import okhttp3.Interceptor;
import okhttp3.RequestBody;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/* JADX INFO: compiled from: Extractors.kt */
/* JADX INFO: loaded from: /home/ubuntu/work/NepaliStream-CNC-Repo/decoded/phisher98/LayarKacaProvider/classes.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0016\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003JH\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00052\b\u0010\u0011\u001a\u0004\u0018\u00010\u00052\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u000f0\u00132\u0012\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u000f0\u0013H\u0096@¢\u0006\u0002\u0010\u0017R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\u0005X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0007R\u0014\u0010\n\u001a\u00020\u000bX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0018"}, d2 = {"Lcom/layarKacaProvider/Hownetwork;", "Lcom/lagradost/cloudstream3/utils/ExtractorApi;", "<init>", "()V", "name", "", "getName", "()Ljava/lang/String;", "mainUrl", "getMainUrl", "requiresReferer", "", "getRequiresReferer", "()Z", "getUrl", "", "url", "referer", "subtitleCallback", "Lkotlin/Function1;", "Lcom/lagradost/cloudstream3/SubtitleFile;", "callback", "Lcom/lagradost/cloudstream3/utils/ExtractorLink;", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "LayarKacaProvider"}, k = 1, mv = {2, 4, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nExtractors.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Extractors.kt\ncom/layarKacaProvider/Hownetwork\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,75:1\n2068#2,2:76\n*S KotlinDebug\n*F\n+ 1 Extractors.kt\ncom/layarKacaProvider/Hownetwork\n*L\n53#1:76,2\n*E\n"})
public class Hownetwork extends ExtractorApi {

    @NotNull
    private final String name = "Hownetwork";

    @NotNull
    private final String mainUrl = "https://stream.hownetwork.xyz";
    private final boolean requiresReferer = true;

    /* JADX INFO: renamed from: com.layarKacaProvider.Hownetwork$getUrl$1 */
    /* JADX INFO: compiled from: Extractors.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.layarKacaProvider.Hownetwork", f = "Extractors.kt", i = {0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1}, l = {35, 49}, m = "getUrl$suspendImpl", n = {"$this", "url", "referer", "subtitleCallback", "callback", "id", "$this", "url", "referer", "subtitleCallback", "callback", "id", "response", "json", "file"}, nl = {45, 53}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8"}, v = 2)
    static final class C00001 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        Object L$7;
        Object L$8;
        int label;
        /* synthetic */ Object result;

        C00001(Continuation<? super C00001> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return Hownetwork.getUrl$suspendImpl(Hownetwork.this, null, null, null, null, (Continuation) this);
        }
    }

    @Nullable
    public Object getUrl(@NotNull String str, @Nullable String str2, @NotNull Function1<? super SubtitleFile, Unit> function1, @NotNull Function1<? super ExtractorLink, Unit> function2, @NotNull Continuation<? super Unit> continuation) {
        return getUrl$suspendImpl(this, str, str2, function1, function2, continuation);
    }

    @NotNull
    public String getName() {
        return this.name;
    }

    @NotNull
    public String getMainUrl() {
        return this.mainUrl;
    }

    public boolean getRequiresReferer() {
        return this.requiresReferer;
    }

    /* JADX WARN: Code duplicated, block: B:20:0x01b8 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:21:0x01b9  */
    /* JADX WARN: Code duplicated, block: B:25:0x01d1 A[LOOP:0: B:23:0x01cb->B:25:0x01d1, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    static /* synthetic */ Object getUrl$suspendImpl(Hownetwork $this, String url, String referer, Function1<? super SubtitleFile, Unit> function1, Function1<? super ExtractorLink, Unit> function2, Continuation<? super Unit> continuation) {
        C00001 c00001;
        String id;
        Object obj;
        int i;
        Hownetwork $this2;
        String url2;
        String referer2;
        Function1<? super SubtitleFile, Unit> function3;
        Object obj2;
        Function1<? super ExtractorLink, Unit> function4;
        Function1<? super ExtractorLink, Unit> function5;
        Object objGenerateM3u8$default;
        Function1<? super ExtractorLink, Unit> function6;
        if (continuation instanceof C00001) {
            c00001 = (C00001) continuation;
            if ((c00001.label & Integer.MIN_VALUE) != 0) {
                c00001.label -= Integer.MIN_VALUE;
            } else {
                c00001 = $this.new C00001(continuation);
            }
        } else {
            c00001 = $this.new C00001(continuation);
        }
        C00001 c00002 = c00001;
        Object $result = c00002.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c00002.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                String id2 = StringsKt.substringAfter$default(url, "id=", (String) null, 2, (Object) null);
                Requests app = MainActivityKt.getApp();
                String str = $this.getMainUrl() + "/api.php?id=" + id2;
                Map mapMapOf = MapsKt.mapOf(new Pair[]{TuplesKt.to("r", ""), TuplesKt.to("d", $this.getMainUrl())});
                Map mapMapOf2 = MapsKt.mapOf(TuplesKt.to("X-Requested-With", "XMLHttpRequest"));
                c00002.L$0 = $this;
                c00002.L$1 = SpillingKt.nullOutSpilledVariable(url);
                c00002.L$2 = SpillingKt.nullOutSpilledVariable(referer);
                c00002.L$3 = SpillingKt.nullOutSpilledVariable(function1);
                c00002.L$4 = function2;
                c00002.L$5 = SpillingKt.nullOutSpilledVariable(id2);
                c00002.label = 1;
                id = id2;
                obj = coroutine_suspended;
                i = 2;
                Object objPost$default = Requests.post$default(app, str, mapMapOf2, url, (Map) null, (Map) null, mapMapOf, (List) null, (Object) null, (RequestBody) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00002, 65496, (Object) null);
                c00002 = c00002;
                if (objPost$default == obj) {
                    return obj;
                }
                $this2 = $this;
                url2 = url;
                referer2 = referer;
                function3 = function1;
                obj2 = objPost$default;
                function4 = function2;
                String response = ((NiceResponse) obj2).getText();
                JSONObject json = new JSONObject(response);
                String file = json.optString("file");
                Log.INSTANCE.d("Phisher", file);
                M3u8Helper.Companion companion = M3u8Helper.Companion;
                String response2 = $this2.getName();
                c00002.L$0 = SpillingKt.nullOutSpilledVariable($this2);
                c00002.L$1 = SpillingKt.nullOutSpilledVariable(url2);
                c00002.L$2 = SpillingKt.nullOutSpilledVariable(referer2);
                c00002.L$3 = SpillingKt.nullOutSpilledVariable(function3);
                c00002.L$4 = function4;
                c00002.L$5 = SpillingKt.nullOutSpilledVariable(id);
                c00002.L$6 = SpillingKt.nullOutSpilledVariable(response);
                c00002.L$7 = SpillingKt.nullOutSpilledVariable(json);
                c00002.L$8 = SpillingKt.nullOutSpilledVariable(file);
                c00002.label = i;
                function5 = function4;
                objGenerateM3u8$default = M3u8Helper.Companion.generateM3u8$default(companion, response2, file, file, (Integer) null, (Map) null, (String) null, c00002, 56, (Object) null);
                if (objGenerateM3u8$default == obj) {
                    return obj;
                }
                function6 = function5;
                Iterable $this$forEach$iv = (Iterable) objGenerateM3u8$default;
                for (Object element$iv : $this$forEach$iv) {
                    function6.invoke(element$iv);
                }
                return Unit.INSTANCE;
            case 1:
                String id3 = (String) c00002.L$5;
                Function1<? super ExtractorLink, Unit> function7 = (Function1) c00002.L$4;
                Function1<? super SubtitleFile, Unit> function8 = (Function1) c00002.L$3;
                String referer3 = (String) c00002.L$2;
                String url3 = (String) c00002.L$1;
                Hownetwork $this3 = (Hownetwork) c00002.L$0;
                ResultKt.throwOnFailure($result);
                $this2 = $this3;
                obj = coroutine_suspended;
                id = id3;
                function4 = function7;
                function3 = function8;
                referer2 = referer3;
                url2 = url3;
                i = 2;
                obj2 = $result;
                String response3 = ((NiceResponse) obj2).getText();
                JSONObject json2 = new JSONObject(response3);
                String file2 = json2.optString("file");
                Log.INSTANCE.d("Phisher", file2);
                M3u8Helper.Companion companion2 = M3u8Helper.Companion;
                String response4 = $this2.getName();
                c00002.L$0 = SpillingKt.nullOutSpilledVariable($this2);
                c00002.L$1 = SpillingKt.nullOutSpilledVariable(url2);
                c00002.L$2 = SpillingKt.nullOutSpilledVariable(referer2);
                c00002.L$3 = SpillingKt.nullOutSpilledVariable(function3);
                c00002.L$4 = function4;
                c00002.L$5 = SpillingKt.nullOutSpilledVariable(id);
                c00002.L$6 = SpillingKt.nullOutSpilledVariable(response3);
                c00002.L$7 = SpillingKt.nullOutSpilledVariable(json2);
                c00002.L$8 = SpillingKt.nullOutSpilledVariable(file2);
                c00002.label = i;
                function5 = function4;
                objGenerateM3u8$default = M3u8Helper.Companion.generateM3u8$default(companion2, response4, file2, file2, (Integer) null, (Map) null, (String) null, c00002, 56, (Object) null);
                if (objGenerateM3u8$default == obj) {
                    return obj;
                }
                function6 = function5;
                Iterable $this$forEach$iv2 = (Iterable) objGenerateM3u8$default;
                while (r12.hasNext()) {
                    function6.invoke(element$iv);
                }
                return Unit.INSTANCE;
            case 2:
                function6 = (Function1) c00002.L$4;
                ResultKt.throwOnFailure($result);
                objGenerateM3u8$default = $result;
                Iterable $this$forEach$iv3 = (Iterable) objGenerateM3u8$default;
                while (r12.hasNext()) {
                    function6.invoke(element$iv);
                }
                return Unit.INSTANCE;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}

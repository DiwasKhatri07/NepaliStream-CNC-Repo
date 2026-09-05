package com.phisher98;

import com.lagradost.cloudstream3.MainActivityKt;
import com.lagradost.cloudstream3.SubtitleFile;
import com.lagradost.cloudstream3.utils.ExtractorApi;
import com.lagradost.cloudstream3.utils.ExtractorApiKt;
import com.lagradost.cloudstream3.utils.ExtractorLink;
import com.lagradost.cloudstream3.utils.M3u8Helper;
import com.lagradost.nicehttp.NiceResponse;
import com.lagradost.nicehttp.Requests;
import com.lagradost.nicehttp.ResponseParser;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.MatchResult;
import kotlin.text.Regex;
import okhttp3.Interceptor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: Extractors.kt */
/* JADX INFO: loaded from: /home/runner/work/NepaliStream-CNC-Repo/NepaliStream-CNC-Repo/decoded/StreamPlay/Phisher98/java/classes.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0016\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003JH\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00052\b\u0010\u0014\u001a\u0004\u0018\u00010\u00052\u0012\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00120\u00162\u0012\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u00120\u0016H\u0096@¢\u0006\u0002\u0010\u001aR\u001a\u0010\u0004\u001a\u00020\u0005X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u0005X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR\u0014\u0010\r\u001a\u00020\u000eX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u001b"}, d2 = {"Lcom/phisher98/Netembed;", "Lcom/lagradost/cloudstream3/utils/ExtractorApi;", "<init>", "()V", "name", "", "getName", "()Ljava/lang/String;", "setName", "(Ljava/lang/String;)V", "mainUrl", "getMainUrl", "setMainUrl", "requiresReferer", "", "getRequiresReferer", "()Z", "getUrl", "", "url", "referer", "subtitleCallback", "Lkotlin/Function1;", "Lcom/lagradost/cloudstream3/SubtitleFile;", "callback", "Lcom/lagradost/cloudstream3/utils/ExtractorLink;", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "StreamPlay"}, k = 1, mv = {2, 4, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nExtractors.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Extractors.kt\ncom/phisher98/Netembed\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,4003:1\n2068#2,2:4004\n*S KotlinDebug\n*F\n+ 1 Extractors.kt\ncom/phisher98/Netembed\n*L\n583#1:4004,2\n*E\n"})
public class Netembed extends ExtractorApi {

    @NotNull
    private String name = "Netembed";

    @NotNull
    private String mainUrl = "https://play.netembed.xyz";
    private final boolean requiresReferer = true;

    /* JADX INFO: renamed from: com.phisher98.Netembed$getUrl$1 */
    /* JADX INFO: compiled from: Extractors.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.phisher98.Netembed", f = "Extractors.kt", i = {0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1}, l = {579, 583}, m = "getUrl$suspendImpl", n = {"$this", "url", "referer", "subtitleCallback", "callback", "$this", "url", "referer", "subtitleCallback", "callback", "response", "script", "m3u8"}, nl = {580, 4004}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7"}, v = 2)
    static final class C00491 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        Object L$7;
        int label;
        /* synthetic */ Object result;

        C00491(Continuation<? super C00491> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return Netembed.getUrl$suspendImpl(Netembed.this, null, null, null, null, (Continuation) this);
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

    public void setName(@NotNull String str) {
        this.name = str;
    }

    @NotNull
    public String getMainUrl() {
        return this.mainUrl;
    }

    public void setMainUrl(@NotNull String str) {
        this.mainUrl = str;
    }

    public boolean getRequiresReferer() {
        return this.requiresReferer;
    }

    /* JADX WARN: Code duplicated, block: B:32:0x0180 A[LOOP:0: B:30:0x017a->B:32:0x0180, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    static /* synthetic */ Object getUrl$suspendImpl(Netembed $this, String url, String referer, Function1<? super SubtitleFile, Unit> function1, Function1<? super ExtractorLink, Unit> function2, Continuation<? super Unit> continuation) {
        C00491 c00491;
        Object obj;
        int i;
        Netembed $this2;
        String url2;
        String referer2;
        Function1<? super SubtitleFile, Unit> function3;
        Object obj2;
        Function1<? super ExtractorLink, Unit> function4;
        MatchResult matchResultFind$default;
        List groupValues;
        String m3u8;
        Object objGenerateM3u8$default;
        Function1<? super ExtractorLink, Unit> function5;
        if (continuation instanceof C00491) {
            c00491 = (C00491) continuation;
            if ((c00491.label & Integer.MIN_VALUE) != 0) {
                c00491.label -= Integer.MIN_VALUE;
            } else {
                c00491 = $this.new C00491(continuation);
            }
        } else {
            c00491 = $this.new C00491(continuation);
        }
        C00491 c00492 = c00491;
        Object $result = c00492.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c00492.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                Requests app = MainActivityKt.getApp();
                c00492.L$0 = $this;
                c00492.L$1 = SpillingKt.nullOutSpilledVariable(url);
                c00492.L$2 = SpillingKt.nullOutSpilledVariable(referer);
                c00492.L$3 = SpillingKt.nullOutSpilledVariable(function1);
                c00492.L$4 = function2;
                c00492.label = 1;
                obj = coroutine_suspended;
                i = 1;
                Object obj3 = Requests.get$default(app, url, (Map) null, referer, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00492, 4090, (Object) null);
                c00492 = c00492;
                if (obj3 == obj) {
                    return obj;
                }
                $this2 = $this;
                url2 = url;
                referer2 = referer;
                function3 = function1;
                obj2 = obj3;
                function4 = function2;
                NiceResponse response = (NiceResponse) obj2;
                String script = ExtractorApiKt.getAndUnpack(response.getText());
                matchResultFind$default = Regex.find$default(new Regex("((https:|http:)//.*\\.m3u8)"), script, 0, 2, (Object) null);
                if (matchResultFind$default != null || (groupValues = matchResultFind$default.getGroupValues()) == null || (m3u8 = (String) CollectionsKt.getOrNull(groupValues, i)) == null) {
                    return Unit.INSTANCE;
                }
                M3u8Helper.Companion companion = M3u8Helper.Companion;
                String name = $this2.getName();
                String str = $this2.getMainUrl() + '/';
                c00492.L$0 = SpillingKt.nullOutSpilledVariable($this2);
                c00492.L$1 = SpillingKt.nullOutSpilledVariable(url2);
                c00492.L$2 = SpillingKt.nullOutSpilledVariable(referer2);
                c00492.L$3 = SpillingKt.nullOutSpilledVariable(function3);
                c00492.L$4 = function4;
                c00492.L$5 = SpillingKt.nullOutSpilledVariable(response);
                c00492.L$6 = SpillingKt.nullOutSpilledVariable(script);
                c00492.L$7 = SpillingKt.nullOutSpilledVariable(m3u8);
                c00492.label = 2;
                Function1<? super ExtractorLink, Unit> function6 = function4;
                objGenerateM3u8$default = M3u8Helper.Companion.generateM3u8$default(companion, name, m3u8, str, (Integer) null, (Map) null, (String) null, c00492, 56, (Object) null);
                if (objGenerateM3u8$default == obj) {
                    return obj;
                }
                function5 = function6;
                Iterable $this$forEach$iv = (Iterable) objGenerateM3u8$default;
                for (Object element$iv : $this$forEach$iv) {
                    function5.invoke(element$iv);
                }
                return Unit.INSTANCE;
            case 1:
                Function1<? super ExtractorLink, Unit> function7 = (Function1) c00492.L$4;
                Function1<? super SubtitleFile, Unit> function8 = (Function1) c00492.L$3;
                String referer3 = (String) c00492.L$2;
                String url3 = (String) c00492.L$1;
                Netembed $this3 = (Netembed) c00492.L$0;
                ResultKt.throwOnFailure($result);
                $this2 = $this3;
                obj = coroutine_suspended;
                function4 = function7;
                function3 = function8;
                referer2 = referer3;
                url2 = url3;
                i = 1;
                obj2 = $result;
                NiceResponse response2 = (NiceResponse) obj2;
                String script2 = ExtractorApiKt.getAndUnpack(response2.getText());
                matchResultFind$default = Regex.find$default(new Regex("((https:|http:)//.*\\.m3u8)"), script2, 0, 2, (Object) null);
                if (matchResultFind$default != null) {
                }
                return Unit.INSTANCE;
            case 2:
                function5 = (Function1) c00492.L$4;
                ResultKt.throwOnFailure($result);
                objGenerateM3u8$default = $result;
                Iterable $this$forEach$iv2 = (Iterable) objGenerateM3u8$default;
                while (r11.hasNext()) {
                    function5.invoke(element$iv);
                }
                return Unit.INSTANCE;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}

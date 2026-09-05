package com.Megakino;

import android.annotation.SuppressLint;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.module.kotlin.ExtensionsKt;
import com.lagradost.cloudstream3.MainActivityKt;
import com.lagradost.cloudstream3.SubtitleFile;
import com.lagradost.cloudstream3.utils.AppUtils;
import com.lagradost.cloudstream3.utils.ExtractorApi;
import com.lagradost.cloudstream3.utils.ExtractorLink;
import com.lagradost.cloudstream3.utils.M3u8Helper;
import com.lagradost.nicehttp.NiceResponse;
import com.lagradost.nicehttp.Requests;
import com.lagradost.nicehttp.ResponseParser;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import okhttp3.Interceptor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: Extractor.kt */
/* JADX INFO: loaded from: /home/runner/work/NepaliStream-CNC-Repo/NepaliStream-CNC-Repo/decoded/Megakino/Phisher98/java/classes.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0016\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003JZ\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00052\b\u0010\u0014\u001a\u0004\u0018\u00010\u00052\u0012\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00120\u00162\u0012\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u00120\u0016H\u0097@b\u0010\b\u001b\u0012\f\b\u001c\u0012\b\b\fJ\u0004\b\b(\u001d¢\u0006\u0002\u0010\u001aR\u001a\u0010\u0004\u001a\u00020\u0005X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u0005X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR\u0014\u0010\r\u001a\u00020\u000eX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u001e"}, d2 = {"Lcom/Megakino/Gxplayer;", "Lcom/lagradost/cloudstream3/utils/ExtractorApi;", "<init>", "()V", "name", "", "getName", "()Ljava/lang/String;", "setName", "(Ljava/lang/String;)V", "mainUrl", "getMainUrl", "setMainUrl", "requiresReferer", "", "getRequiresReferer", "()Z", "getUrl", "", "url", "referer", "subtitleCallback", "Lkotlin/Function1;", "Lcom/lagradost/cloudstream3/SubtitleFile;", "callback", "Lcom/lagradost/cloudstream3/utils/ExtractorLink;", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Landroid/annotation/SuppressLint;", "value", "SuspiciousIndentation", "Megakino"}, k = 1, mv = {2, 4, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nExtractor.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Extractor.kt\ncom/Megakino/Gxplayer\n+ 2 Extensions.kt\ncom/fasterxml/jackson/module/kotlin/ExtensionsKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,58:1\n50#2:59\n43#2:60\n2068#3,2:61\n*S KotlinDebug\n*F\n+ 1 Extractor.kt\ncom/Megakino/Gxplayer\n*L\n27#1:59\n27#1:60\n32#1:61,2\n*E\n"})
public class Gxplayer extends ExtractorApi {

    @NotNull
    private String name = "Gxplayer";

    @NotNull
    private String mainUrl = "https://watch.gxplayer.xyz";
    private final boolean requiresReferer = true;

    /* JADX INFO: renamed from: com.Megakino.Gxplayer$getUrl$1 */
    /* JADX INFO: compiled from: Extractor.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.Megakino.Gxplayer", f = "Extractor.kt", i = {0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1}, l = {25, 28}, m = "getUrl$suspendImpl", n = {"$this", "url", "referer", "subtitleCallback", "callback", "$this", "url", "referer", "subtitleCallback", "callback", "json", "objectMapper", "video"}, nl = {26, 32}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7"}, v = 2)
    static final class C00001 extends ContinuationImpl {
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

        C00001(Continuation<? super C00001> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return Gxplayer.getUrl$suspendImpl(Gxplayer.this, null, null, null, null, (Continuation) this);
        }
    }

    @SuppressLint({"SuspiciousIndentation"})
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

    /* JADX WARN: Code duplicated, block: B:20:0x01c1 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:21:0x01c2  */
    /* JADX WARN: Code duplicated, block: B:25:0x01db A[LOOP:0: B:23:0x01d5->B:25:0x01db, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    @SuppressLint({"SuspiciousIndentation"})
    static /* synthetic */ Object getUrl$suspendImpl(Gxplayer $this, String url, String referer, Function1<? super SubtitleFile, Unit> function1, Function1<? super ExtractorLink, Unit> function2, Continuation<? super Unit> continuation) {
        C00001 c00001;
        Object obj;
        Gxplayer $this2;
        String url2;
        String referer2;
        Function1<? super SubtitleFile, Unit> function3;
        Object obj2;
        AppUtils appUtils;
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
                AppUtils appUtils2 = AppUtils.INSTANCE;
                Requests app = MainActivityKt.getApp();
                String mainUrl = $this.getMainUrl();
                c00002.L$0 = $this;
                c00002.L$1 = SpillingKt.nullOutSpilledVariable(url);
                c00002.L$2 = SpillingKt.nullOutSpilledVariable(referer);
                c00002.L$3 = SpillingKt.nullOutSpilledVariable(function1);
                c00002.L$4 = function2;
                c00002.L$5 = appUtils2;
                c00002.label = 1;
                obj = coroutine_suspended;
                Object obj3 = Requests.get$default(app, url, (Map) null, mainUrl, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00002, 4090, (Object) null);
                c00002 = c00002;
                if (obj3 == obj) {
                    return obj;
                }
                $this2 = $this;
                url2 = url;
                referer2 = referer;
                function3 = function1;
                obj2 = obj3;
                appUtils = appUtils2;
                function4 = function2;
                String json = appUtils.toJson(StringsKt.substringBefore$default(StringsKt.substringAfter$default(((NiceResponse) obj2).getText(), "var video = ", (String) null, 2, (Object) null), ";", (String) null, 2, (Object) null));
                ObjectMapper objectMapper = ExtensionsKt.jacksonObjectMapper();
                Details video = (Details) objectMapper.readValue(json, new TypeReference<Details>() { // from class: com.Megakino.Gxplayer$getUrl$suspendImpl$$inlined$readValue$1
                });
                M3u8Helper.Companion companion = M3u8Helper.Companion;
                String name = $this2.getName();
                String str = $this2.getMainUrl() + "/m3u8/" + video.getUid() + '/' + video.getMd5() + "/master.txt?s=1&id=" + video.getId() + "&cache=" + video.getStatus();
                String str2 = $this2.getMainUrl() + '/';
                c00002.L$0 = SpillingKt.nullOutSpilledVariable($this2);
                c00002.L$1 = SpillingKt.nullOutSpilledVariable(url2);
                c00002.L$2 = SpillingKt.nullOutSpilledVariable(referer2);
                c00002.L$3 = SpillingKt.nullOutSpilledVariable(function3);
                c00002.L$4 = function4;
                c00002.L$5 = SpillingKt.nullOutSpilledVariable(json);
                c00002.L$6 = SpillingKt.nullOutSpilledVariable(objectMapper);
                c00002.L$7 = SpillingKt.nullOutSpilledVariable(video);
                c00002.label = 2;
                function5 = function4;
                objGenerateM3u8$default = M3u8Helper.Companion.generateM3u8$default(companion, name, str, str2, (Integer) null, (Map) null, (String) null, c00002, 56, (Object) null);
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
                AppUtils appUtils3 = (AppUtils) c00002.L$5;
                Function1<? super ExtractorLink, Unit> function7 = (Function1) c00002.L$4;
                Function1<? super SubtitleFile, Unit> function8 = (Function1) c00002.L$3;
                String referer3 = (String) c00002.L$2;
                String url3 = (String) c00002.L$1;
                Gxplayer $this3 = (Gxplayer) c00002.L$0;
                ResultKt.throwOnFailure($result);
                $this2 = $this3;
                obj = coroutine_suspended;
                function4 = function7;
                function3 = function8;
                referer2 = referer3;
                url2 = url3;
                appUtils = appUtils3;
                obj2 = $result;
                String json2 = appUtils.toJson(StringsKt.substringBefore$default(StringsKt.substringAfter$default(((NiceResponse) obj2).getText(), "var video = ", (String) null, 2, (Object) null), ";", (String) null, 2, (Object) null));
                ObjectMapper objectMapper2 = ExtensionsKt.jacksonObjectMapper();
                Details video2 = (Details) objectMapper2.readValue(json2, new TypeReference<Details>() { // from class: com.Megakino.Gxplayer$getUrl$suspendImpl$$inlined$readValue$1
                });
                M3u8Helper.Companion companion2 = M3u8Helper.Companion;
                String name2 = $this2.getName();
                String str3 = $this2.getMainUrl() + "/m3u8/" + video2.getUid() + '/' + video2.getMd5() + "/master.txt?s=1&id=" + video2.getId() + "&cache=" + video2.getStatus();
                String str4 = $this2.getMainUrl() + '/';
                c00002.L$0 = SpillingKt.nullOutSpilledVariable($this2);
                c00002.L$1 = SpillingKt.nullOutSpilledVariable(url2);
                c00002.L$2 = SpillingKt.nullOutSpilledVariable(referer2);
                c00002.L$3 = SpillingKt.nullOutSpilledVariable(function3);
                c00002.L$4 = function4;
                c00002.L$5 = SpillingKt.nullOutSpilledVariable(json2);
                c00002.L$6 = SpillingKt.nullOutSpilledVariable(objectMapper2);
                c00002.L$7 = SpillingKt.nullOutSpilledVariable(video2);
                c00002.label = 2;
                function5 = function4;
                objGenerateM3u8$default = M3u8Helper.Companion.generateM3u8$default(companion2, name2, str3, str4, (Integer) null, (Map) null, (String) null, c00002, 56, (Object) null);
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

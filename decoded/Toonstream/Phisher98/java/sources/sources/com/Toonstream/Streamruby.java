package com.Toonstream;

import com.lagradost.cloudstream3.MainActivityKt;
import com.lagradost.cloudstream3.utils.ExtractorApi;
import com.lagradost.cloudstream3.utils.ExtractorApiKt;
import com.lagradost.cloudstream3.utils.ExtractorLink;
import com.lagradost.cloudstream3.utils.ExtractorLinkType;
import com.lagradost.nicehttp.NiceResponse;
import com.lagradost.nicehttp.Requests;
import com.lagradost.nicehttp.ResponseParser;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.MatchResult;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import okhttp3.Interceptor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: Extractors.kt */
/* JADX INFO: loaded from: /home/ubuntu/work/NepaliStream-CNC-Repo/decoded/phisher98/Toonstream/classes.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0016\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J(\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u00122\u0006\u0010\u0014\u001a\u00020\u00052\b\u0010\u0015\u001a\u0004\u0018\u00010\u0005H\u0096@¢\u0006\u0002\u0010\u0016R\u001a\u0010\u0004\u001a\u00020\u0005X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u0005X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR\u0014\u0010\r\u001a\u00020\u000eX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0017"}, d2 = {"Lcom/Toonstream/Streamruby;", "Lcom/lagradost/cloudstream3/utils/ExtractorApi;", "<init>", "()V", "name", "", "getName", "()Ljava/lang/String;", "setName", "(Ljava/lang/String;)V", "mainUrl", "getMainUrl", "setMainUrl", "requiresReferer", "", "getRequiresReferer", "()Z", "getUrl", "", "Lcom/lagradost/cloudstream3/utils/ExtractorLink;", "url", "referer", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Toonstream"}, k = 1, mv = {2, 4, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nExtractors.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Extractors.kt\ncom/Toonstream/Streamruby\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,257:1\n1#2:258\n*E\n"})
public class Streamruby extends ExtractorApi {
    private final boolean requiresReferer;

    @NotNull
    private String name = "Streamruby";

    @NotNull
    private String mainUrl = "streamruby.com";

    /* JADX INFO: renamed from: com.Toonstream.Streamruby$getUrl$1 */
    /* JADX INFO: compiled from: Extractors.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.Toonstream.Streamruby", f = "Extractors.kt", i = {0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1}, l = {139, 144}, m = "getUrl$suspendImpl", n = {"$this", "url", "referer", "newUrl", "$this", "url", "referer", "newUrl", "txt", "m3u8", "it"}, nl = {140, 143}, s = {"L$0", "L$1", "L$2", "L$3", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6"}, v = 2)
    static final class C00031 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        int label;
        /* synthetic */ Object result;

        C00031(Continuation<? super C00031> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return Streamruby.getUrl$suspendImpl(Streamruby.this, null, null, (Continuation) this);
        }
    }

    @Nullable
    public Object getUrl(@NotNull String str, @Nullable String str2, @NotNull Continuation<? super List<? extends ExtractorLink>> continuation) {
        return getUrl$suspendImpl(this, str, str2, continuation);
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

    /* JADX WARN: Code duplicated, block: B:27:0x011b  */
    /* JADX WARN: Code duplicated, block: B:30:0x0120  */
    /* JADX WARN: Code duplicated, block: B:32:0x012b  */
    /* JADX WARN: Code duplicated, block: B:34:0x012e  */
    /* JADX WARN: Code duplicated, block: B:35:0x0130  */
    /* JADX WARN: Code duplicated, block: B:37:0x0133  */
    /* JADX WARN: Code duplicated, block: B:39:0x0181 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:40:0x0182  */
    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    static /* synthetic */ Object getUrl$suspendImpl(Streamruby $this, String url, String referer, Continuation<? super List<? extends ExtractorLink>> continuation) {
        C00031 c00031;
        Object obj;
        int i;
        int i2;
        Object obj2;
        Streamruby $this2;
        String url2;
        String referer2;
        String newUrl;
        String txt;
        MatchResult matchResultFind$default;
        String str;
        String m3u8;
        String it;
        Object objNewExtractorLink;
        Streamruby $this3;
        String referer3;
        String referer4;
        String newUrl2;
        String txt2;
        String it2;
        List groupValues;
        if (continuation instanceof C00031) {
            c00031 = (C00031) continuation;
            if ((c00031.label & Integer.MIN_VALUE) != 0) {
                c00031.label -= Integer.MIN_VALUE;
            } else {
                c00031 = $this.new C00031(continuation);
            }
        } else {
            c00031 = $this.new C00031(continuation);
        }
        C00031 c00032 = c00031;
        Object $result = c00032.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c00032.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                String newUrl3 = StringsKt.contains$default(url, "/e/", false, 2, (Object) null) ? StringsKt.replace$default(url, "/e", "", false, 4, (Object) null) : url;
                Requests app = MainActivityKt.getApp();
                c00032.L$0 = $this;
                c00032.L$1 = SpillingKt.nullOutSpilledVariable(url);
                c00032.L$2 = SpillingKt.nullOutSpilledVariable(referer);
                c00032.L$3 = SpillingKt.nullOutSpilledVariable(newUrl3);
                c00032.label = 1;
                obj = coroutine_suspended;
                i = 2;
                i2 = 0;
                obj2 = Requests.get$default(app, newUrl3, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00032, 4094, (Object) null);
                c00032 = c00032;
                if (obj2 == obj) {
                    return obj;
                }
                $this2 = $this;
                url2 = url;
                referer2 = referer;
                newUrl = newUrl3;
                txt = ((NiceResponse) obj2).getText();
                matchResultFind$default = Regex.find$default(new Regex("file:\\s*\"(.*?m3u8.*?)\""), txt, i2, i, (Object) null);
                if (matchResultFind$default != null || (groupValues = matchResultFind$default.getGroupValues()) == null) {
                    str = null;
                } else {
                    str = (String) CollectionsKt.getOrNull(groupValues, 1);
                }
                m3u8 = str;
                if (m3u8 != null) {
                    if (m3u8.length() > 0) {
                        i2 = 1;
                    }
                    if (i2 != 0) {
                        it = m3u8;
                    } else {
                        it = null;
                    }
                    if (it != null) {
                        String name = $this2.getName();
                        String name2 = $this2.getName();
                        ExtractorLinkType infer_type = ExtractorApiKt.getINFER_TYPE();
                        Streamruby$getUrl$3$1 streamruby$getUrl$3$1 = new Streamruby$getUrl$3$1($this2, null);
                        c00032.L$0 = SpillingKt.nullOutSpilledVariable($this2);
                        c00032.L$1 = SpillingKt.nullOutSpilledVariable(url2);
                        c00032.L$2 = SpillingKt.nullOutSpilledVariable(referer2);
                        c00032.L$3 = SpillingKt.nullOutSpilledVariable(newUrl);
                        c00032.L$4 = SpillingKt.nullOutSpilledVariable(txt);
                        c00032.L$5 = SpillingKt.nullOutSpilledVariable(m3u8);
                        c00032.L$6 = SpillingKt.nullOutSpilledVariable(it);
                        c00032.label = i;
                        objNewExtractorLink = ExtractorApiKt.newExtractorLink(name2, name, it, infer_type, streamruby$getUrl$3$1, c00032);
                        if (objNewExtractorLink == obj) {
                            return obj;
                        }
                        $this3 = $this2;
                        referer3 = referer2;
                        referer4 = url2;
                        newUrl2 = newUrl;
                        txt2 = txt;
                        it2 = m3u8;
                        return CollectionsKt.listOf(objNewExtractorLink);
                    }
                }
                return null;
            case 1:
                String newUrl4 = (String) c00032.L$3;
                referer2 = (String) c00032.L$2;
                url2 = (String) c00032.L$1;
                Streamruby $this4 = (Streamruby) c00032.L$0;
                ResultKt.throwOnFailure($result);
                $this2 = $this4;
                obj = coroutine_suspended;
                i = 2;
                obj2 = $result;
                i2 = 0;
                newUrl = newUrl4;
                txt = ((NiceResponse) obj2).getText();
                matchResultFind$default = Regex.find$default(new Regex("file:\\s*\"(.*?m3u8.*?)\""), txt, i2, i, (Object) null);
                if (matchResultFind$default != null) {
                    str = null;
                } else {
                    str = null;
                }
                m3u8 = str;
                if (m3u8 != null) {
                    if (m3u8.length() > 0) {
                        i2 = 1;
                    }
                    if (i2 != 0) {
                        it = m3u8;
                    } else {
                        it = null;
                    }
                    if (it != null) {
                        String name3 = $this2.getName();
                        String name4 = $this2.getName();
                        ExtractorLinkType infer_type2 = ExtractorApiKt.getINFER_TYPE();
                        Streamruby$getUrl$3$1 streamruby$getUrl$3$2 = new Streamruby$getUrl$3$1($this2, null);
                        c00032.L$0 = SpillingKt.nullOutSpilledVariable($this2);
                        c00032.L$1 = SpillingKt.nullOutSpilledVariable(url2);
                        c00032.L$2 = SpillingKt.nullOutSpilledVariable(referer2);
                        c00032.L$3 = SpillingKt.nullOutSpilledVariable(newUrl);
                        c00032.L$4 = SpillingKt.nullOutSpilledVariable(txt);
                        c00032.L$5 = SpillingKt.nullOutSpilledVariable(m3u8);
                        c00032.L$6 = SpillingKt.nullOutSpilledVariable(it);
                        c00032.label = i;
                        objNewExtractorLink = ExtractorApiKt.newExtractorLink(name4, name3, it, infer_type2, streamruby$getUrl$3$2, c00032);
                        if (objNewExtractorLink == obj) {
                            return obj;
                        }
                        $this3 = $this2;
                        referer3 = referer2;
                        referer4 = url2;
                        newUrl2 = newUrl;
                        txt2 = txt;
                        it2 = m3u8;
                        return CollectionsKt.listOf(objNewExtractorLink);
                    }
                }
                return null;
            case 2:
                it2 = (String) c00032.L$5;
                txt2 = (String) c00032.L$4;
                newUrl2 = (String) c00032.L$3;
                referer3 = (String) c00032.L$2;
                referer4 = (String) c00032.L$1;
                $this3 = (Streamruby) c00032.L$0;
                ResultKt.throwOnFailure($result);
                objNewExtractorLink = $result;
                return CollectionsKt.listOf(objNewExtractorLink);
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}

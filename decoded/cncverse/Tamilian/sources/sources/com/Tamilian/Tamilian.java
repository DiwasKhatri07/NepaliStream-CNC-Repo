package com.Tamilian;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.GradientDrawable;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.util.Base64;
import android.view.View;
import android.view.Window;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.lagradost.cloudstream3.HomePageResponse;
import com.lagradost.cloudstream3.MainAPIKt;
import com.lagradost.cloudstream3.MainActivityKt;
import com.lagradost.cloudstream3.MainPageRequest;
import com.lagradost.cloudstream3.SubtitleFile;
import com.lagradost.cloudstream3.TvType;
import com.lagradost.cloudstream3.metaproviders.TmdbLink;
import com.lagradost.cloudstream3.metaproviders.TmdbProvider;
import com.lagradost.cloudstream3.mvvm.ArchComponentExtKt;
import com.lagradost.cloudstream3.ui.settings.Globals;
import com.lagradost.cloudstream3.utils.AppUtils;
import com.lagradost.cloudstream3.utils.ExtractorApiKt;
import com.lagradost.cloudstream3.utils.ExtractorLink;
import com.lagradost.nicehttp.NiceResponse;
import com.lagradost.nicehttp.Requests;
import com.lagradost.nicehttp.ResponseParser;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MagicApiIntrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.KType;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;
import kotlinx.serialization.DeserializationStrategy;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerializationException;
import kotlinx.serialization.SerializersKt;
import kotlinx.serialization.modules.SerializersModule;
import okhttp3.Interceptor;
import okhttp3.RequestBody;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jsoup.nodes.Element;

/* JADX INFO: compiled from: Tamilian.kt */
/* JADX INFO: loaded from: /home/ubuntu/work/NepaliStream-CNC-Repo/decoded/cncverse/Tamilian/classes.dex */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 42\u00020\u0001:\u0003456B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001e\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!H\u0096@¢\u0006\u0002\u0010\"JF\u0010#\u001a\u00020\u000b2\u0006\u0010$\u001a\u00020\u00052\u0006\u0010%\u001a\u00020\u000b2\u0012\u0010&\u001a\u000e\u0012\u0004\u0012\u00020(\u0012\u0004\u0012\u00020)0'2\u0012\u0010*\u001a\u000e\u0012\u0004\u0012\u00020+\u0012\u0004\u0012\u00020)0'H\u0096@¢\u0006\u0002\u0010,J\f\u0010-\u001a\u00020.*\u00020/H\u0002J\b\u00100\u001a\u00020)H\u0002J\b\u00101\u001a\u00020)H\u0002J\u0010\u00102\u001a\u00020)2\u0006\u00103\u001a\u00020\u0005H\u0002R\u001a\u0010\u0004\u001a\u00020\u0005X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\u00020\u000bX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u001a\u0010\u000e\u001a\u00020\u0005X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0007\"\u0004\b\u0010\u0010\tR\u0014\u0010\u0011\u001a\u00020\u000bX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\rR\u0014\u0010\u0013\u001a\u00020\u000bX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\rR\u0014\u0010\u0015\u001a\u00020\u000bX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\rR\u001a\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00190\u0018X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001b¨\u00067"}, d2 = {"Lcom/Tamilian/Tamilian;", "Lcom/lagradost/cloudstream3/metaproviders/TmdbProvider;", "<init>", "()V", "name", "", "getName", "()Ljava/lang/String;", "setName", "(Ljava/lang/String;)V", "hasMainPage", "", "getHasMainPage", "()Z", "lang", "getLang", "setLang", "instantLinkLoading", "getInstantLinkLoading", "useMetaLoadResponse", "getUseMetaLoadResponse", "hasQuickSearch", "getHasQuickSearch", "supportedTypes", "", "Lcom/lagradost/cloudstream3/TvType;", "getSupportedTypes", "()Ljava/util/Set;", "getMainPage", "Lcom/lagradost/cloudstream3/HomePageResponse;", "page", "", "request", "Lcom/lagradost/cloudstream3/MainPageRequest;", "(ILcom/lagradost/cloudstream3/MainPageRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "loadLinks", "data", "isCasting", "subtitleCallback", "Lkotlin/Function1;", "Lcom/lagradost/cloudstream3/SubtitleFile;", "", "callback", "Lcom/lagradost/cloudstream3/utils/ExtractorLink;", "(Ljava/lang/String;ZLkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "toLinkData", "Lcom/Tamilian/Tamilian$LinkData;", "Lcom/lagradost/cloudstream3/metaproviders/TmdbLink;", "showSubscriptionPopupIfNeeded", "showTelegramPopup", "openInExternalBrowser", "url", "Companion", "LinkData", "VideoData", "Tamilian_debug"}, k = 1, mv = {2, 3, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nTamilian.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Tamilian.kt\ncom/Tamilian/Tamilian\n+ 2 AppUtils.kt\ncom/lagradost/cloudstream3/utils/AppUtils\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 4 Extensions.kt\ncom/fasterxml/jackson/module/kotlin/ExtensionsKt\n+ 5 NiceResponse.kt\ncom/lagradost/nicehttp/NiceResponse\n*L\n1#1,402:1\n63#2:403\n64#2,15:405\n1#3:404\n1#3:422\n50#4:420\n43#4:421\n67#5,5:423\n*S KotlinDebug\n*F\n+ 1 Tamilian.kt\ncom/Tamilian/Tamilian\n*L\n81#1:403\n81#1:405,15\n81#1:404\n81#1:420\n81#1:421\n88#1:423,5\n*E\n"})
public final class Tamilian extends TmdbProvider {
    private static final long BROWSER_DEBOUNCE_MS = 10000;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    public static final String HOST = "https://embedojo.net";

    @NotNull
    private static final String OMG10 = "aHR0cHM6Ly9vbWcxMC5jb20vNC8xMTEwNDQ4OQ==";

    @Nullable
    private static Context context;
    private static volatile long lastBrowserOpenMs;
    private static volatile boolean subscriptionPopupShown;
    private static volatile boolean telegramPopupShown;

    @NotNull
    private String name = "Tamilian";
    private final boolean hasMainPage = true;

    @NotNull
    private String lang = "ta";
    private final boolean instantLinkLoading = true;
    private final boolean useMetaLoadResponse = true;
    private final boolean hasQuickSearch = true;

    @NotNull
    private final Set<TvType> supportedTypes = SetsKt.setOf(TvType.Movie);

    /* JADX INFO: renamed from: com.Tamilian.Tamilian$loadLinks$1 */
    /* JADX INFO: compiled from: Tamilian.kt */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.Tamilian.Tamilian", f = "Tamilian.kt", i = {0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2}, l = {82, 87, 91}, m = "loadLinks", n = {"data", "subtitleCallback", "callback", "mediaData", "isCasting", "data", "subtitleCallback", "callback", "mediaData", "script", "token", "isCasting", "data", "subtitleCallback", "callback", "mediaData", "script", "token", "m3u8", "headers", "it", "isCasting", "$i$a$-let-Tamilian$loadLinks$3"}, nl = {83, 88, 104}, s = {"L$0", "L$1", "L$2", "L$3", "Z$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "Z$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "Z$0", "I$0"}, v = 2)
    static final class C00001 extends ContinuationImpl {
        int I$0;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        Object L$7;
        Object L$8;
        boolean Z$0;
        int label;
        /* synthetic */ Object result;

        C00001(Continuation<? super C00001> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return Tamilian.this.loadLinks(null, false, null, null, (Continuation) this);
        }
    }

    @NotNull
    public String getName() {
        return this.name;
    }

    public void setName(@NotNull String str) {
        this.name = str;
    }

    public boolean getHasMainPage() {
        return this.hasMainPage;
    }

    @NotNull
    public String getLang() {
        return this.lang;
    }

    public void setLang(@NotNull String str) {
        this.lang = str;
    }

    public boolean getInstantLinkLoading() {
        return this.instantLinkLoading;
    }

    public boolean getUseMetaLoadResponse() {
        return this.useMetaLoadResponse;
    }

    public boolean getHasQuickSearch() {
        return this.hasQuickSearch;
    }

    @NotNull
    public Set<TvType> getSupportedTypes() {
        return this.supportedTypes;
    }

    /* JADX INFO: compiled from: Tamilian.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u000e\u0010\n\u001a\u00020\u000bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u000bX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u000eX\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/Tamilian/Tamilian$Companion;", "", "<init>", "()V", "context", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "setContext", "(Landroid/content/Context;)V", "HOST", "", "OMG10", "lastBrowserOpenMs", "", "telegramPopupShown", "", "subscriptionPopupShown", "BROWSER_DEBOUNCE_MS", "Tamilian_debug"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @Nullable
        public final Context getContext() {
            return Tamilian.context;
        }

        public final void setContext(@Nullable Context context) {
            Tamilian.context = context;
        }
    }

    @Nullable
    public Object getMainPage(int page, @NotNull MainPageRequest request, @NotNull Continuation<? super HomePageResponse> continuation) {
        showTelegramPopup();
        showSubscriptionPopupIfNeeded();
        return super.getMainPage(page, request, continuation);
    }

    /* JADX WARN: Code duplicated, block: B:76:0x025a  */
    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    /* JADX WARN: Code duplicated, block: B:82:0x026d  */
    /* JADX WARN: Code duplicated, block: B:85:0x0301 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:86:0x0302  */
    /* JADX WARN: Code duplicated, block: B:94:0x0344  */
    /* JADX WARN: Code duplicated, block: B:96:0x039b A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:97:0x039c  */
    /* JADX WARN: Code duplicated, block: B:99:0x03af  */
    @Nullable
    public Object loadLinks(@NotNull String data, boolean isCasting, @NotNull Function1<? super SubtitleFile, Unit> function1, @NotNull Function1<? super ExtractorLink, Unit> function2, @NotNull Continuation<? super Boolean> continuation) {
        C00001 c00001;
        Object obj;
        Object objDecodeFromString;
        int i;
        boolean z;
        String str;
        C00001 c00002;
        Function1<? super SubtitleFile, Unit> function3;
        Function1<? super ExtractorLink, Unit> function4;
        LinkData mediaData;
        Object obj2;
        String data2;
        boolean isCasting2;
        Element elementSelectFirst;
        String it;
        String token;
        String script;
        String token2;
        boolean isCasting3;
        Function1<? super ExtractorLink, Unit> function5;
        Object objPost$default;
        C00001 c00003;
        String data3;
        String script2;
        Object obj3;
        Function1<? super SubtitleFile, Unit> function6;
        LinkData mediaData2;
        Function1<? super ExtractorLink, Unit> function7;
        String token3;
        boolean isCasting4;
        String strSubstringAfter$default;
        String it2;
        Object safe;
        VideoData m3u8;
        Map headers;
        Object objSafeApiCall;
        Map headers2;
        boolean isCasting5;
        String script3;
        VideoData m3u9;
        if (continuation instanceof C00001) {
            c00001 = (C00001) continuation;
            if ((c00001.label & Integer.MIN_VALUE) != 0) {
                c00001.label -= Integer.MIN_VALUE;
            } else {
                c00001 = new C00001(continuation);
            }
        } else {
            c00001 = new C00001(continuation);
        }
        C00001 c00004 = c00001;
        Object $result = c00004.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c00004.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                Tamilian $this$loadLinks_u24lambda_u240 = this;
                final Context _ctx = context;
                SharedPreferences _prefs = _ctx != null ? _ctx.getSharedPreferences("CNCVerseSubscription", 0) : null;
                String _mode = _prefs != null ? _prefs.getString("mode", "ads") : null;
                long _expiresAt = _prefs != null ? _prefs.getLong("expires_at", 0L) : 0L;
                long _nowSec = System.currentTimeMillis() / 1000;
                boolean _isSubscribed = Intrinsics.areEqual(_mode, "subscription") && (_expiresAt == 0 || _expiresAt > _nowSec);
                if (!_isSubscribed) {
                    if (Intrinsics.areEqual(_mode, "subscription") && _expiresAt > 0 && _expiresAt <= _nowSec) {
                        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.Tamilian.Tamilian$$ExternalSyntheticLambda5
                            @Override // java.lang.Runnable
                            public final void run() {
                                Tamilian.loadLinks$lambda$0$0(_ctx);
                            }
                        });
                    }
                    $this$loadLinks_u24lambda_u240.openInExternalBrowser(new String(Base64.decode(OMG10, 0), Charsets.UTF_8));
                }
                AppUtils appUtils = AppUtils.INSTANCE;
                try {
                    Result.Companion companion = Result.Companion;
                    KType kTypeTypeOf = Reflection.typeOf(TmdbLink.class);
                    MagicApiIntrinsics.voidMagicApiCall("kotlinx.serialization.serializer.simple");
                    obj = Result.constructor-impl(SerializersKt.serializer(kTypeTypeOf));
                    break;
                } catch (Throwable th) {
                    Result.Companion companion2 = Result.Companion;
                    obj = Result.constructor-impl(ResultKt.createFailure(th));
                }
                if (Result.exceptionOrNull-impl(obj) != null) {
                    try {
                        Result.Companion companion3 = Result.Companion;
                        obj = Result.constructor-impl(SerializersModule.getContextual$default(MainAPIKt.getJson().getSerializersModule(), Reflection.getOrCreateKotlinClass(TmdbLink.class), (List) null, 2, (Object) null));
                    } catch (Throwable th2) {
                        Result.Companion companion4 = Result.Companion;
                        obj = Result.constructor-impl(ResultKt.createFailure(th2));
                    }
                    break;
                }
                if (Result.isFailure-impl(obj)) {
                    obj = null;
                }
                DeserializationStrategy deserializationStrategy = (KSerializer) obj;
                if (deserializationStrategy != null) {
                    try {
                        objDecodeFromString = MainAPIKt.getJson().decodeFromString(deserializationStrategy, data);
                    } catch (SerializationException e) {
                        ArchComponentExtKt.logError(e);
                        ObjectMapper $this$readValue$iv$iv = MainAPIKt.getMapper();
                        objDecodeFromString = $this$readValue$iv$iv.readValue(data, new TypeReference<TmdbLink>() { // from class: com.Tamilian.Tamilian$loadLinks$$inlined$parseJson$1
                        });
                    } catch (Throwable th3) {
                        ObjectMapper $this$readValue$iv$iv2 = MainAPIKt.getMapper();
                        objDecodeFromString = $this$readValue$iv$iv2.readValue(data, new TypeReference<TmdbLink>() { // from class: com.Tamilian.Tamilian$loadLinks$$inlined$parseJson$1
                        });
                    }
                    break;
                } else {
                    ObjectMapper $this$readValue$iv$iv3 = MainAPIKt.getMapper();
                    objDecodeFromString = $this$readValue$iv$iv3.readValue(data, new TypeReference<TmdbLink>() { // from class: com.Tamilian.Tamilian$loadLinks$$inlined$parseJson$1
                    });
                }
                LinkData mediaData3 = toLinkData((TmdbLink) objDecodeFromString);
                i = 2;
                Requests app = MainActivityKt.getApp();
                String str2 = "https://embedojo.net/tamil/tmdb/" + mediaData3.getTmdbId();
                c00004.L$0 = SpillingKt.nullOutSpilledVariable(data);
                c00004.L$1 = SpillingKt.nullOutSpilledVariable(function1);
                c00004.L$2 = function2;
                c00004.L$3 = SpillingKt.nullOutSpilledVariable(mediaData3);
                c00004.Z$0 = isCasting;
                c00004.label = 1;
                z = true;
                str = null;
                Object obj4 = Requests.get$default(app, str2, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00004, 4094, (Object) null);
                c00002 = c00004;
                if (obj4 == coroutine_suspended) {
                    return coroutine_suspended;
                }
                function3 = function1;
                function4 = function2;
                mediaData = mediaData3;
                obj2 = obj4;
                data2 = data;
                isCasting2 = isCasting;
                elementSelectFirst = ((NiceResponse) obj2).getDocument().selectFirst("script:containsData(function(p,a,c,k,e,d))");
                if (elementSelectFirst != null || (it2 = elementSelectFirst.data()) == null) {
                    it = str;
                } else {
                    it = ExtractorApiKt.getAndUnpack(it2);
                }
                if (it != null || (strSubstringAfter$default = StringsKt.substringAfter$default(it, "FirePlayer(\"", str, i, str)) == null) {
                    token = str;
                } else {
                    token = StringsKt.substringBefore$default(strSubstringAfter$default, "\",", str, i, str);
                }
                Map mapMapOf = MapsKt.mapOf(TuplesKt.to("X-Requested-With", "XMLHttpRequest"));
                c00002.L$0 = SpillingKt.nullOutSpilledVariable(data2);
                c00002.L$1 = SpillingKt.nullOutSpilledVariable(function3);
                c00002.L$2 = function4;
                c00002.L$3 = SpillingKt.nullOutSpilledVariable(mediaData);
                c00002.L$4 = SpillingKt.nullOutSpilledVariable(it);
                c00002.L$5 = SpillingKt.nullOutSpilledVariable(token);
                c00002.Z$0 = isCasting2;
                c00002.label = i;
                script = it;
                token2 = token;
                isCasting3 = isCasting2;
                C00001 c00005 = c00002;
                function5 = function4;
                objPost$default = Requests.post$default(MainActivityKt.getApp(), "https://embedojo.net/player/index.php?data=" + token + "&do=getVideo", mapMapOf, (String) null, (Map) null, (Map) null, (Map) null, (List) null, (Object) null, (RequestBody) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00005, 65532, (Object) null);
                c00003 = c00005;
                if (objPost$default == coroutine_suspended) {
                    return coroutine_suspended;
                }
                data3 = data2;
                script2 = script;
                obj3 = objPost$default;
                function6 = function3;
                mediaData2 = mediaData;
                function7 = function5;
                token3 = token2;
                isCasting4 = isCasting3;
                NiceResponse this_$iv = (NiceResponse) obj3;
                try {
                    ResponseParser parser = this_$iv.getParser();
                    Intrinsics.checkNotNull(parser);
                    safe = parser.parseSafe(this_$iv.getText(), Reflection.getOrCreateKotlinClass(VideoData.class));
                } catch (Exception e$iv) {
                    e$iv.printStackTrace();
                    safe = null;
                }
                m3u8 = (VideoData) safe;
                headers = MapsKt.mapOf(TuplesKt.to("Origin", HOST));
                if (m3u8 != null) {
                    Function1<? super ExtractorLink, Unit> function8 = function7;
                    Tamilian$loadLinks$3$1 tamilian$loadLinks$3$1 = new Tamilian$loadLinks$3$1(function8, this, m3u8, headers, null);
                    c00003.L$0 = SpillingKt.nullOutSpilledVariable(data3);
                    c00003.L$1 = SpillingKt.nullOutSpilledVariable(function6);
                    c00003.L$2 = SpillingKt.nullOutSpilledVariable(function8);
                    c00003.L$3 = SpillingKt.nullOutSpilledVariable(mediaData2);
                    c00003.L$4 = SpillingKt.nullOutSpilledVariable(script2);
                    c00003.L$5 = SpillingKt.nullOutSpilledVariable(token3);
                    c00003.L$6 = SpillingKt.nullOutSpilledVariable(m3u8);
                    c00003.L$7 = SpillingKt.nullOutSpilledVariable(headers);
                    c00003.L$8 = SpillingKt.nullOutSpilledVariable(m3u8);
                    c00003.Z$0 = isCasting4;
                    c00003.I$0 = 0;
                    c00003.label = 3;
                    objSafeApiCall = ArchComponentExtKt.safeApiCall(tamilian$loadLinks$3$1, c00003);
                    if (objSafeApiCall == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    $result = objSafeApiCall;
                    headers2 = headers;
                    isCasting5 = isCasting4;
                    script3 = script2;
                    m3u9 = m3u8;
                }
                return Boxing.boxBoolean(z);
            case 1:
                boolean isCasting6 = c00004.Z$0;
                LinkData mediaData4 = (LinkData) c00004.L$3;
                Function1<? super ExtractorLink, Unit> function9 = (Function1) c00004.L$2;
                Function1<? super SubtitleFile, Unit> function10 = (Function1) c00004.L$1;
                String data4 = (String) c00004.L$0;
                ResultKt.throwOnFailure($result);
                c00002 = c00004;
                str = null;
                isCasting2 = isCasting6;
                mediaData = mediaData4;
                function4 = function9;
                function3 = function10;
                data2 = data4;
                i = 2;
                z = true;
                obj2 = $result;
                elementSelectFirst = ((NiceResponse) obj2).getDocument().selectFirst("script:containsData(function(p,a,c,k,e,d))");
                if (elementSelectFirst != null) {
                    it = str;
                } else {
                    it = str;
                }
                if (it != null) {
                    token = str;
                } else {
                    token = str;
                }
                Map mapMapOf2 = MapsKt.mapOf(TuplesKt.to("X-Requested-With", "XMLHttpRequest"));
                c00002.L$0 = SpillingKt.nullOutSpilledVariable(data2);
                c00002.L$1 = SpillingKt.nullOutSpilledVariable(function3);
                c00002.L$2 = function4;
                c00002.L$3 = SpillingKt.nullOutSpilledVariable(mediaData);
                c00002.L$4 = SpillingKt.nullOutSpilledVariable(it);
                c00002.L$5 = SpillingKt.nullOutSpilledVariable(token);
                c00002.Z$0 = isCasting2;
                c00002.label = i;
                script = it;
                token2 = token;
                isCasting3 = isCasting2;
                C00001 c00006 = c00002;
                function5 = function4;
                objPost$default = Requests.post$default(MainActivityKt.getApp(), "https://embedojo.net/player/index.php?data=" + token + "&do=getVideo", mapMapOf2, (String) null, (Map) null, (Map) null, (Map) null, (List) null, (Object) null, (RequestBody) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00006, 65532, (Object) null);
                c00003 = c00006;
                if (objPost$default == coroutine_suspended) {
                    return coroutine_suspended;
                }
                data3 = data2;
                script2 = script;
                obj3 = objPost$default;
                function6 = function3;
                mediaData2 = mediaData;
                function7 = function5;
                token3 = token2;
                isCasting4 = isCasting3;
                NiceResponse this_$iv2 = (NiceResponse) obj3;
                ResponseParser parser2 = this_$iv2.getParser();
                Intrinsics.checkNotNull(parser2);
                safe = parser2.parseSafe(this_$iv2.getText(), Reflection.getOrCreateKotlinClass(VideoData.class));
                m3u8 = (VideoData) safe;
                headers = MapsKt.mapOf(TuplesKt.to("Origin", HOST));
                if (m3u8 != null) {
                    Function1<? super ExtractorLink, Unit> function11 = function7;
                    Tamilian$loadLinks$3$1 tamilian$loadLinks$3$2 = new Tamilian$loadLinks$3$1(function11, this, m3u8, headers, null);
                    c00003.L$0 = SpillingKt.nullOutSpilledVariable(data3);
                    c00003.L$1 = SpillingKt.nullOutSpilledVariable(function6);
                    c00003.L$2 = SpillingKt.nullOutSpilledVariable(function11);
                    c00003.L$3 = SpillingKt.nullOutSpilledVariable(mediaData2);
                    c00003.L$4 = SpillingKt.nullOutSpilledVariable(script2);
                    c00003.L$5 = SpillingKt.nullOutSpilledVariable(token3);
                    c00003.L$6 = SpillingKt.nullOutSpilledVariable(m3u8);
                    c00003.L$7 = SpillingKt.nullOutSpilledVariable(headers);
                    c00003.L$8 = SpillingKt.nullOutSpilledVariable(m3u8);
                    c00003.Z$0 = isCasting4;
                    c00003.I$0 = 0;
                    c00003.label = 3;
                    objSafeApiCall = ArchComponentExtKt.safeApiCall(tamilian$loadLinks$3$2, c00003);
                    if (objSafeApiCall == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    $result = objSafeApiCall;
                    headers2 = headers;
                    isCasting5 = isCasting4;
                    script3 = script2;
                    m3u9 = m3u8;
                }
                return Boxing.boxBoolean(z);
            case 2:
                boolean isCasting7 = c00004.Z$0;
                String token4 = (String) c00004.L$5;
                script2 = (String) c00004.L$4;
                LinkData mediaData5 = (LinkData) c00004.L$3;
                function7 = (Function1) c00004.L$2;
                Function1<? super SubtitleFile, Unit> function12 = (Function1) c00004.L$1;
                String data5 = (String) c00004.L$0;
                ResultKt.throwOnFailure($result);
                c00003 = c00004;
                function6 = function12;
                data3 = data5;
                z = true;
                mediaData2 = mediaData5;
                token3 = token4;
                isCasting4 = isCasting7;
                obj3 = $result;
                NiceResponse this_$iv3 = (NiceResponse) obj3;
                ResponseParser parser3 = this_$iv3.getParser();
                Intrinsics.checkNotNull(parser3);
                safe = parser3.parseSafe(this_$iv3.getText(), Reflection.getOrCreateKotlinClass(VideoData.class));
                m3u8 = (VideoData) safe;
                headers = MapsKt.mapOf(TuplesKt.to("Origin", HOST));
                if (m3u8 != null) {
                    Function1<? super ExtractorLink, Unit> function13 = function7;
                    Tamilian$loadLinks$3$1 tamilian$loadLinks$3$3 = new Tamilian$loadLinks$3$1(function13, this, m3u8, headers, null);
                    c00003.L$0 = SpillingKt.nullOutSpilledVariable(data3);
                    c00003.L$1 = SpillingKt.nullOutSpilledVariable(function6);
                    c00003.L$2 = SpillingKt.nullOutSpilledVariable(function13);
                    c00003.L$3 = SpillingKt.nullOutSpilledVariable(mediaData2);
                    c00003.L$4 = SpillingKt.nullOutSpilledVariable(script2);
                    c00003.L$5 = SpillingKt.nullOutSpilledVariable(token3);
                    c00003.L$6 = SpillingKt.nullOutSpilledVariable(m3u8);
                    c00003.L$7 = SpillingKt.nullOutSpilledVariable(headers);
                    c00003.L$8 = SpillingKt.nullOutSpilledVariable(m3u8);
                    c00003.Z$0 = isCasting4;
                    c00003.I$0 = 0;
                    c00003.label = 3;
                    objSafeApiCall = ArchComponentExtKt.safeApiCall(tamilian$loadLinks$3$3, c00003);
                    if (objSafeApiCall == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    $result = objSafeApiCall;
                    headers2 = headers;
                    isCasting5 = isCasting4;
                    script3 = script2;
                    m3u9 = m3u8;
                }
                return Boxing.boxBoolean(z);
            case 3:
                int i2 = c00004.I$0;
                isCasting5 = c00004.Z$0;
                Map headers3 = (Map) c00004.L$7;
                m3u9 = (VideoData) c00004.L$6;
                String script4 = (String) c00004.L$4;
                ResultKt.throwOnFailure($result);
                headers2 = headers3;
                script3 = script4;
                z = true;
                return Boxing.boxBoolean(z);
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void loadLinks$lambda$0$0(Context $_ctx) {
        Toast.makeText($_ctx, "⚠️(Opening ads) Subscription expired. If you have renewed your subscription, please re-verify it in Subscription Manager.", 1).show();
    }

    private final LinkData toLinkData(TmdbLink $this$toLinkData) {
        return new LinkData(null, null, $this$toLinkData.getImdbID(), $this$toLinkData.getTmdbID(), null, null, $this$toLinkData.getSeason(), $this$toLinkData.getEpisode(), null, null, $this$toLinkData.getMovieName(), null, null, false, null, null, null, null, null, null, false, false, false, 8387379, null);
    }

    /* JADX INFO: compiled from: Tamilian.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b@\b\u0086\b\u0018\u00002\u00020\u0001B\u0093\u0002\u0012\n\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0003\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010\t\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0003\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010\f\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0003\u0010\r\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0003\u0010\u000e\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0003\u0010\u000f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010\u0010\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0003\u0010\u0011\u001a\u00020\u0012\u0012\n\b\u0003\u0010\u0013\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010\u0014\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010\u0015\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0003\u0010\u0016\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0003\u0010\u0017\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0003\u0010\u0018\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0003\u0010\u0019\u001a\u00020\u0012\u0012\b\b\u0003\u0010\u001a\u001a\u00020\u0012\u0012\b\b\u0003\u0010\u001b\u001a\u00020\u0012¢\u0006\u0004\b\u001c\u0010\u001dJ\u0010\u00105\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u001fJ\u0010\u00106\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u001fJ\u000b\u00107\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u0010\u00108\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u001fJ\u0010\u00109\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u001fJ\u000b\u0010:\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u0010\u0010;\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u001fJ\u0010\u0010<\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u001fJ\u000b\u0010=\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010>\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010?\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u0010\u0010@\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u001fJ\u000b\u0010A\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\t\u0010B\u001a\u00020\u0012HÆ\u0003J\u0010\u0010C\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u001fJ\u0010\u0010D\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u001fJ\u000b\u0010E\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010F\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010G\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010H\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\t\u0010I\u001a\u00020\u0012HÆ\u0003J\t\u0010J\u001a\u00020\u0012HÆ\u0003J\t\u0010K\u001a\u00020\u0012HÆ\u0003J\u009a\u0002\u0010L\u001a\u00020\u00002\n\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0003\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\t\u001a\u0004\u0018\u00010\u00062\n\b\u0003\u0010\n\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u000b\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\f\u001a\u0004\u0018\u00010\u00062\n\b\u0003\u0010\r\u001a\u0004\u0018\u00010\u00062\n\b\u0003\u0010\u000e\u001a\u0004\u0018\u00010\u00062\n\b\u0003\u0010\u000f\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0010\u001a\u0004\u0018\u00010\u00062\b\b\u0003\u0010\u0011\u001a\u00020\u00122\n\b\u0003\u0010\u0013\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0014\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0015\u001a\u0004\u0018\u00010\u00062\n\b\u0003\u0010\u0016\u001a\u0004\u0018\u00010\u00062\n\b\u0003\u0010\u0017\u001a\u0004\u0018\u00010\u00062\n\b\u0003\u0010\u0018\u001a\u0004\u0018\u00010\u00062\b\b\u0003\u0010\u0019\u001a\u00020\u00122\b\b\u0003\u0010\u001a\u001a\u00020\u00122\b\b\u0003\u0010\u001b\u001a\u00020\u0012HÆ\u0001¢\u0006\u0002\u0010MJ\u0014\u0010N\u001a\u00020\u00122\b\u0010O\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010P\u001a\u00020\u0003HÖ\u0081\u0004J\n\u0010Q\u001a\u00020\u0006HÖ\u0081\u0004R\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010 \u001a\u0004\b\u001e\u0010\u001fR\u001a\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010 \u001a\u0004\b!\u0010\u001fR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u001a\u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010 \u001a\u0004\b$\u0010\u001fR\u001a\u0010\b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010 \u001a\u0004\b%\u0010\u001fR\u0018\u0010\t\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b&\u0010#R\u001a\u0010\n\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010 \u001a\u0004\b'\u0010\u001fR\u001a\u0010\u000b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010 \u001a\u0004\b(\u0010\u001fR\u0018\u0010\f\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b)\u0010#R\u0018\u0010\r\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b*\u0010#R\u0018\u0010\u000e\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b+\u0010#R\u001a\u0010\u000f\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010 \u001a\u0004\b,\u0010\u001fR\u0018\u0010\u0010\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b-\u0010#R\u0016\u0010\u0011\u001a\u00020\u00128\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010.R\u001a\u0010\u0013\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010 \u001a\u0004\b/\u0010\u001fR\u001a\u0010\u0014\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010 \u001a\u0004\b0\u0010\u001fR\u0018\u0010\u0015\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b1\u0010#R\u0018\u0010\u0016\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b2\u0010#R\u0018\u0010\u0017\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b3\u0010#R\u0018\u0010\u0018\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b4\u0010#R\u0016\u0010\u0019\u001a\u00020\u00128\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010.R\u0016\u0010\u001a\u001a\u00020\u00128\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010.R\u0016\u0010\u001b\u001a\u00020\u00128\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010.¨\u0006R"}, d2 = {"Lcom/Tamilian/Tamilian$LinkData;", "", "simklId", "", "traktId", "imdbId", "", "tmdbId", "tvdbId", "type", "season", "episode", "aniId", "malId", "title", "year", "orgTitle", "isAnime", "", "airedYear", "lastSeason", "epsTitle", "jpTitle", "date", "airedDate", "isAsian", "isBollywood", "isCartoon", "<init>", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;ZLjava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZZZ)V", "getSimklId", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getTraktId", "getImdbId", "()Ljava/lang/String;", "getTmdbId", "getTvdbId", "getType", "getSeason", "getEpisode", "getAniId", "getMalId", "getTitle", "getYear", "getOrgTitle", "()Z", "getAiredYear", "getLastSeason", "getEpsTitle", "getJpTitle", "getDate", "getAiredDate", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component20", "component21", "component22", "component23", "copy", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;ZLjava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZZZ)Lcom/Tamilian/Tamilian$LinkData;", "equals", "other", "hashCode", "toString", "Tamilian_debug"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final /* data */ class LinkData {

        @JsonProperty("airedDate")
        @Nullable
        private final String airedDate;

        @JsonProperty("airedYear")
        @Nullable
        private final Integer airedYear;

        @JsonProperty("aniId")
        @Nullable
        private final String aniId;

        @JsonProperty("date")
        @Nullable
        private final String date;

        @JsonProperty("episode")
        @Nullable
        private final Integer episode;

        @JsonProperty("epsTitle")
        @Nullable
        private final String epsTitle;

        @JsonProperty("imdbId")
        @Nullable
        private final String imdbId;

        @JsonProperty("isAnime")
        private final boolean isAnime;

        @JsonProperty("isAsian")
        private final boolean isAsian;

        @JsonProperty("isBollywood")
        private final boolean isBollywood;

        @JsonProperty("isCartoon")
        private final boolean isCartoon;

        @JsonProperty("jpTitle")
        @Nullable
        private final String jpTitle;

        @JsonProperty("lastSeason")
        @Nullable
        private final Integer lastSeason;

        @JsonProperty("malId")
        @Nullable
        private final String malId;

        @JsonProperty("orgTitle")
        @Nullable
        private final String orgTitle;

        @JsonProperty("season")
        @Nullable
        private final Integer season;

        @JsonProperty("simklId")
        @Nullable
        private final Integer simklId;

        @JsonProperty("title")
        @Nullable
        private final String title;

        @JsonProperty("tmdbId")
        @Nullable
        private final Integer tmdbId;

        @JsonProperty("traktId")
        @Nullable
        private final Integer traktId;

        @JsonProperty("tvdbId")
        @Nullable
        private final Integer tvdbId;

        @JsonProperty("type")
        @Nullable
        private final String type;

        @JsonProperty("year")
        @Nullable
        private final Integer year;

        public LinkData() {
            this(null, null, null, null, null, null, null, null, null, null, null, null, null, false, null, null, null, null, null, null, false, false, false, 8388607, null);
        }

        public static /* synthetic */ LinkData copy$default(LinkData linkData, Integer num, Integer num2, String str, Integer num3, Integer num4, String str2, Integer num5, Integer num6, String str3, String str4, String str5, Integer num7, String str6, boolean z, Integer num8, Integer num9, String str7, String str8, String str9, String str10, boolean z2, boolean z3, boolean z4, int i, Object obj) {
            boolean z5;
            boolean z6;
            Integer num10 = (i & 1) != 0 ? linkData.simklId : num;
            Integer num11 = (i & 2) != 0 ? linkData.traktId : num2;
            String str11 = (i & 4) != 0 ? linkData.imdbId : str;
            Integer num12 = (i & 8) != 0 ? linkData.tmdbId : num3;
            Integer num13 = (i & 16) != 0 ? linkData.tvdbId : num4;
            String str12 = (i & 32) != 0 ? linkData.type : str2;
            Integer num14 = (i & 64) != 0 ? linkData.season : num5;
            Integer num15 = (i & 128) != 0 ? linkData.episode : num6;
            String str13 = (i & 256) != 0 ? linkData.aniId : str3;
            String str14 = (i & 512) != 0 ? linkData.malId : str4;
            String str15 = (i & 1024) != 0 ? linkData.title : str5;
            Integer num16 = (i & 2048) != 0 ? linkData.year : num7;
            String str16 = (i & 4096) != 0 ? linkData.orgTitle : str6;
            boolean z7 = (i & 8192) != 0 ? linkData.isAnime : z;
            Integer num17 = num10;
            Integer num18 = (i & 16384) != 0 ? linkData.airedYear : num8;
            Integer num19 = (i & 32768) != 0 ? linkData.lastSeason : num9;
            String str17 = (i & 65536) != 0 ? linkData.epsTitle : str7;
            String str18 = (i & 131072) != 0 ? linkData.jpTitle : str8;
            String str19 = (i & 262144) != 0 ? linkData.date : str9;
            String str20 = (i & 524288) != 0 ? linkData.airedDate : str10;
            boolean z8 = (i & 1048576) != 0 ? linkData.isAsian : z2;
            boolean z9 = (i & 2097152) != 0 ? linkData.isBollywood : z3;
            if ((i & 4194304) != 0) {
                z6 = z9;
                z5 = linkData.isCartoon;
            } else {
                z5 = z4;
                z6 = z9;
            }
            return linkData.copy(num17, num11, str11, num12, num13, str12, num14, num15, str13, str14, str15, num16, str16, z7, num18, num19, str17, str18, str19, str20, z8, z6, z5);
        }

        @Nullable
        /* JADX INFO: renamed from: component1, reason: from getter */
        public final Integer getSimklId() {
            return this.simklId;
        }

        @Nullable
        /* JADX INFO: renamed from: component10, reason: from getter */
        public final String getMalId() {
            return this.malId;
        }

        @Nullable
        /* JADX INFO: renamed from: component11, reason: from getter */
        public final String getTitle() {
            return this.title;
        }

        @Nullable
        /* JADX INFO: renamed from: component12, reason: from getter */
        public final Integer getYear() {
            return this.year;
        }

        @Nullable
        /* JADX INFO: renamed from: component13, reason: from getter */
        public final String getOrgTitle() {
            return this.orgTitle;
        }

        /* JADX INFO: renamed from: component14, reason: from getter */
        public final boolean getIsAnime() {
            return this.isAnime;
        }

        @Nullable
        /* JADX INFO: renamed from: component15, reason: from getter */
        public final Integer getAiredYear() {
            return this.airedYear;
        }

        @Nullable
        /* JADX INFO: renamed from: component16, reason: from getter */
        public final Integer getLastSeason() {
            return this.lastSeason;
        }

        @Nullable
        /* JADX INFO: renamed from: component17, reason: from getter */
        public final String getEpsTitle() {
            return this.epsTitle;
        }

        @Nullable
        /* JADX INFO: renamed from: component18, reason: from getter */
        public final String getJpTitle() {
            return this.jpTitle;
        }

        @Nullable
        /* JADX INFO: renamed from: component19, reason: from getter */
        public final String getDate() {
            return this.date;
        }

        @Nullable
        /* JADX INFO: renamed from: component2, reason: from getter */
        public final Integer getTraktId() {
            return this.traktId;
        }

        @Nullable
        /* JADX INFO: renamed from: component20, reason: from getter */
        public final String getAiredDate() {
            return this.airedDate;
        }

        /* JADX INFO: renamed from: component21, reason: from getter */
        public final boolean getIsAsian() {
            return this.isAsian;
        }

        /* JADX INFO: renamed from: component22, reason: from getter */
        public final boolean getIsBollywood() {
            return this.isBollywood;
        }

        /* JADX INFO: renamed from: component23, reason: from getter */
        public final boolean getIsCartoon() {
            return this.isCartoon;
        }

        @Nullable
        /* JADX INFO: renamed from: component3, reason: from getter */
        public final String getImdbId() {
            return this.imdbId;
        }

        @Nullable
        /* JADX INFO: renamed from: component4, reason: from getter */
        public final Integer getTmdbId() {
            return this.tmdbId;
        }

        @Nullable
        /* JADX INFO: renamed from: component5, reason: from getter */
        public final Integer getTvdbId() {
            return this.tvdbId;
        }

        @Nullable
        /* JADX INFO: renamed from: component6, reason: from getter */
        public final String getType() {
            return this.type;
        }

        @Nullable
        /* JADX INFO: renamed from: component7, reason: from getter */
        public final Integer getSeason() {
            return this.season;
        }

        @Nullable
        /* JADX INFO: renamed from: component8, reason: from getter */
        public final Integer getEpisode() {
            return this.episode;
        }

        @Nullable
        /* JADX INFO: renamed from: component9, reason: from getter */
        public final String getAniId() {
            return this.aniId;
        }

        @NotNull
        public final LinkData copy(@JsonProperty("simklId") @Nullable Integer simklId, @JsonProperty("traktId") @Nullable Integer traktId, @JsonProperty("imdbId") @Nullable String imdbId, @JsonProperty("tmdbId") @Nullable Integer tmdbId, @JsonProperty("tvdbId") @Nullable Integer tvdbId, @JsonProperty("type") @Nullable String type, @JsonProperty("season") @Nullable Integer season, @JsonProperty("episode") @Nullable Integer episode, @JsonProperty("aniId") @Nullable String aniId, @JsonProperty("malId") @Nullable String malId, @JsonProperty("title") @Nullable String title, @JsonProperty("year") @Nullable Integer year, @JsonProperty("orgTitle") @Nullable String orgTitle, @JsonProperty("isAnime") boolean isAnime, @JsonProperty("airedYear") @Nullable Integer airedYear, @JsonProperty("lastSeason") @Nullable Integer lastSeason, @JsonProperty("epsTitle") @Nullable String epsTitle, @JsonProperty("jpTitle") @Nullable String jpTitle, @JsonProperty("date") @Nullable String date, @JsonProperty("airedDate") @Nullable String airedDate, @JsonProperty("isAsian") boolean isAsian, @JsonProperty("isBollywood") boolean isBollywood, @JsonProperty("isCartoon") boolean isCartoon) {
            return new LinkData(simklId, traktId, imdbId, tmdbId, tvdbId, type, season, episode, aniId, malId, title, year, orgTitle, isAnime, airedYear, lastSeason, epsTitle, jpTitle, date, airedDate, isAsian, isBollywood, isCartoon);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof LinkData)) {
                return false;
            }
            LinkData linkData = (LinkData) other;
            return Intrinsics.areEqual(this.simklId, linkData.simklId) && Intrinsics.areEqual(this.traktId, linkData.traktId) && Intrinsics.areEqual(this.imdbId, linkData.imdbId) && Intrinsics.areEqual(this.tmdbId, linkData.tmdbId) && Intrinsics.areEqual(this.tvdbId, linkData.tvdbId) && Intrinsics.areEqual(this.type, linkData.type) && Intrinsics.areEqual(this.season, linkData.season) && Intrinsics.areEqual(this.episode, linkData.episode) && Intrinsics.areEqual(this.aniId, linkData.aniId) && Intrinsics.areEqual(this.malId, linkData.malId) && Intrinsics.areEqual(this.title, linkData.title) && Intrinsics.areEqual(this.year, linkData.year) && Intrinsics.areEqual(this.orgTitle, linkData.orgTitle) && this.isAnime == linkData.isAnime && Intrinsics.areEqual(this.airedYear, linkData.airedYear) && Intrinsics.areEqual(this.lastSeason, linkData.lastSeason) && Intrinsics.areEqual(this.epsTitle, linkData.epsTitle) && Intrinsics.areEqual(this.jpTitle, linkData.jpTitle) && Intrinsics.areEqual(this.date, linkData.date) && Intrinsics.areEqual(this.airedDate, linkData.airedDate) && this.isAsian == linkData.isAsian && this.isBollywood == linkData.isBollywood && this.isCartoon == linkData.isCartoon;
        }

        public int hashCode() {
            return ((((((((((((((((((((((((((((((((((((((((((((this.simklId == null ? 0 : this.simklId.hashCode()) * 31) + (this.traktId == null ? 0 : this.traktId.hashCode())) * 31) + (this.imdbId == null ? 0 : this.imdbId.hashCode())) * 31) + (this.tmdbId == null ? 0 : this.tmdbId.hashCode())) * 31) + (this.tvdbId == null ? 0 : this.tvdbId.hashCode())) * 31) + (this.type == null ? 0 : this.type.hashCode())) * 31) + (this.season == null ? 0 : this.season.hashCode())) * 31) + (this.episode == null ? 0 : this.episode.hashCode())) * 31) + (this.aniId == null ? 0 : this.aniId.hashCode())) * 31) + (this.malId == null ? 0 : this.malId.hashCode())) * 31) + (this.title == null ? 0 : this.title.hashCode())) * 31) + (this.year == null ? 0 : this.year.hashCode())) * 31) + (this.orgTitle == null ? 0 : this.orgTitle.hashCode())) * 31) + Tamilian$LinkData$$ExternalSyntheticBackport0.m0m(this.isAnime)) * 31) + (this.airedYear == null ? 0 : this.airedYear.hashCode())) * 31) + (this.lastSeason == null ? 0 : this.lastSeason.hashCode())) * 31) + (this.epsTitle == null ? 0 : this.epsTitle.hashCode())) * 31) + (this.jpTitle == null ? 0 : this.jpTitle.hashCode())) * 31) + (this.date == null ? 0 : this.date.hashCode())) * 31) + (this.airedDate != null ? this.airedDate.hashCode() : 0)) * 31) + Tamilian$LinkData$$ExternalSyntheticBackport0.m0m(this.isAsian)) * 31) + Tamilian$LinkData$$ExternalSyntheticBackport0.m0m(this.isBollywood)) * 31) + Tamilian$LinkData$$ExternalSyntheticBackport0.m0m(this.isCartoon);
        }

        @NotNull
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("LinkData(simklId=").append(this.simklId).append(", traktId=").append(this.traktId).append(", imdbId=").append(this.imdbId).append(", tmdbId=").append(this.tmdbId).append(", tvdbId=").append(this.tvdbId).append(", type=").append(this.type).append(", season=").append(this.season).append(", episode=").append(this.episode).append(", aniId=").append(this.aniId).append(", malId=").append(this.malId).append(", title=").append(this.title).append(", year=");
            sb.append(this.year).append(", orgTitle=").append(this.orgTitle).append(", isAnime=").append(this.isAnime).append(", airedYear=").append(this.airedYear).append(", lastSeason=").append(this.lastSeason).append(", epsTitle=").append(this.epsTitle).append(", jpTitle=").append(this.jpTitle).append(", date=").append(this.date).append(", airedDate=").append(this.airedDate).append(", isAsian=").append(this.isAsian).append(", isBollywood=").append(this.isBollywood).append(", isCartoon=").append(this.isCartoon);
            sb.append(')');
            return sb.toString();
        }

        public LinkData(@JsonProperty("simklId") @Nullable Integer simklId, @JsonProperty("traktId") @Nullable Integer traktId, @JsonProperty("imdbId") @Nullable String imdbId, @JsonProperty("tmdbId") @Nullable Integer tmdbId, @JsonProperty("tvdbId") @Nullable Integer tvdbId, @JsonProperty("type") @Nullable String type, @JsonProperty("season") @Nullable Integer season, @JsonProperty("episode") @Nullable Integer episode, @JsonProperty("aniId") @Nullable String aniId, @JsonProperty("malId") @Nullable String malId, @JsonProperty("title") @Nullable String title, @JsonProperty("year") @Nullable Integer year, @JsonProperty("orgTitle") @Nullable String orgTitle, @JsonProperty("isAnime") boolean isAnime, @JsonProperty("airedYear") @Nullable Integer airedYear, @JsonProperty("lastSeason") @Nullable Integer lastSeason, @JsonProperty("epsTitle") @Nullable String epsTitle, @JsonProperty("jpTitle") @Nullable String jpTitle, @JsonProperty("date") @Nullable String date, @JsonProperty("airedDate") @Nullable String airedDate, @JsonProperty("isAsian") boolean isAsian, @JsonProperty("isBollywood") boolean isBollywood, @JsonProperty("isCartoon") boolean isCartoon) {
            this.simklId = simklId;
            this.traktId = traktId;
            this.imdbId = imdbId;
            this.tmdbId = tmdbId;
            this.tvdbId = tvdbId;
            this.type = type;
            this.season = season;
            this.episode = episode;
            this.aniId = aniId;
            this.malId = malId;
            this.title = title;
            this.year = year;
            this.orgTitle = orgTitle;
            this.isAnime = isAnime;
            this.airedYear = airedYear;
            this.lastSeason = lastSeason;
            this.epsTitle = epsTitle;
            this.jpTitle = jpTitle;
            this.date = date;
            this.airedDate = airedDate;
            this.isAsian = isAsian;
            this.isBollywood = isBollywood;
            this.isCartoon = isCartoon;
        }

        public /* synthetic */ LinkData(Integer num, Integer num2, String str, Integer num3, Integer num4, String str2, Integer num5, Integer num6, String str3, String str4, String str5, Integer num7, String str6, boolean z, Integer num8, Integer num9, String str7, String str8, String str9, String str10, boolean z2, boolean z3, boolean z4, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : num, (i & 2) != 0 ? null : num2, (i & 4) != 0 ? null : str, (i & 8) != 0 ? null : num3, (i & 16) != 0 ? null : num4, (i & 32) != 0 ? null : str2, (i & 64) != 0 ? null : num5, (i & 128) != 0 ? null : num6, (i & 256) != 0 ? null : str3, (i & 512) != 0 ? null : str4, (i & 1024) != 0 ? null : str5, (i & 2048) != 0 ? null : num7, (i & 4096) != 0 ? null : str6, (i & 8192) != 0 ? false : z, (i & 16384) != 0 ? null : num8, (i & 32768) != 0 ? null : num9, (i & 65536) != 0 ? null : str7, (i & 131072) != 0 ? null : str8, (i & 262144) != 0 ? null : str9, (i & 524288) != 0 ? null : str10, (i & 1048576) != 0 ? false : z2, (i & 2097152) != 0 ? false : z3, (i & 4194304) == 0 ? z4 : false);
        }

        @Nullable
        public final Integer getSimklId() {
            return this.simklId;
        }

        @Nullable
        public final Integer getTraktId() {
            return this.traktId;
        }

        @Nullable
        public final String getImdbId() {
            return this.imdbId;
        }

        @Nullable
        public final Integer getTmdbId() {
            return this.tmdbId;
        }

        @Nullable
        public final Integer getTvdbId() {
            return this.tvdbId;
        }

        @Nullable
        public final String getType() {
            return this.type;
        }

        @Nullable
        public final Integer getSeason() {
            return this.season;
        }

        @Nullable
        public final Integer getEpisode() {
            return this.episode;
        }

        @Nullable
        public final String getAniId() {
            return this.aniId;
        }

        @Nullable
        public final String getMalId() {
            return this.malId;
        }

        @Nullable
        public final String getTitle() {
            return this.title;
        }

        @Nullable
        public final Integer getYear() {
            return this.year;
        }

        @Nullable
        public final String getOrgTitle() {
            return this.orgTitle;
        }

        public final boolean isAnime() {
            return this.isAnime;
        }

        @Nullable
        public final Integer getAiredYear() {
            return this.airedYear;
        }

        @Nullable
        public final Integer getLastSeason() {
            return this.lastSeason;
        }

        @Nullable
        public final String getEpsTitle() {
            return this.epsTitle;
        }

        @Nullable
        public final String getJpTitle() {
            return this.jpTitle;
        }

        @Nullable
        public final String getDate() {
            return this.date;
        }

        @Nullable
        public final String getAiredDate() {
            return this.airedDate;
        }

        public final boolean isAsian() {
            return this.isAsian;
        }

        public final boolean isBollywood() {
            return this.isBollywood;
        }

        public final boolean isCartoon() {
            return this.isCartoon;
        }
    }

    /* JADX INFO: compiled from: Tamilian.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0019\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001BO\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u000e\u0010\b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\t\u0012\u000e\u0010\n\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\t\u0012\u0006\u0010\u000b\u001a\u00020\u0005¢\u0006\u0004\b\f\u0010\rJ\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0005HÆ\u0003J\u0011\u0010\u001c\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\tHÆ\u0003J\u0011\u0010\u001d\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\tHÆ\u0003J\t\u0010\u001e\u001a\u00020\u0005HÆ\u0003J_\u0010\u001f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\u0010\b\u0002\u0010\b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\t2\u0010\b\u0002\u0010\n\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\t2\b\b\u0002\u0010\u000b\u001a\u00020\u0005HÆ\u0001J\u0014\u0010 \u001a\u00020\u00032\b\u0010!\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\"\u001a\u00020#HÖ\u0081\u0004J\n\u0010$\u001a\u00020\u0005HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011R\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0011R\u0019\u0010\b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0019\u0010\n\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0015R\u0011\u0010\u000b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0011¨\u0006%"}, d2 = {"Lcom/Tamilian/Tamilian$VideoData;", "", "hls", "", "videoImage", "", "videoSource", "securedLink", "downloadLinks", "", "attachmentLinks", "ck", "<init>", "(ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/util/List;Ljava/lang/String;)V", "getHls", "()Z", "getVideoImage", "()Ljava/lang/String;", "getVideoSource", "getSecuredLink", "getDownloadLinks", "()Ljava/util/List;", "getAttachmentLinks", "getCk", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "other", "hashCode", "", "toString", "Tamilian_debug"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final /* data */ class VideoData {

        @NotNull
        private final List<Object> attachmentLinks;

        @NotNull
        private final String ck;

        @NotNull
        private final List<Object> downloadLinks;
        private final boolean hls;

        @NotNull
        private final String securedLink;

        @NotNull
        private final String videoImage;

        @NotNull
        private final String videoSource;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ VideoData copy$default(VideoData videoData, boolean z, String str, String str2, String str3, List list, List list2, String str4, int i, Object obj) {
            if ((i & 1) != 0) {
                z = videoData.hls;
            }
            if ((i & 2) != 0) {
                str = videoData.videoImage;
            }
            if ((i & 4) != 0) {
                str2 = videoData.videoSource;
            }
            if ((i & 8) != 0) {
                str3 = videoData.securedLink;
            }
            if ((i & 16) != 0) {
                list = videoData.downloadLinks;
            }
            if ((i & 32) != 0) {
                list2 = videoData.attachmentLinks;
            }
            if ((i & 64) != 0) {
                str4 = videoData.ck;
            }
            List list3 = list2;
            String str5 = str4;
            List list4 = list;
            String str6 = str2;
            return videoData.copy(z, str, str6, str3, list4, list3, str5);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final boolean getHls() {
            return this.hls;
        }

        @NotNull
        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getVideoImage() {
            return this.videoImage;
        }

        @NotNull
        /* JADX INFO: renamed from: component3, reason: from getter */
        public final String getVideoSource() {
            return this.videoSource;
        }

        @NotNull
        /* JADX INFO: renamed from: component4, reason: from getter */
        public final String getSecuredLink() {
            return this.securedLink;
        }

        @NotNull
        public final List<Object> component5() {
            return this.downloadLinks;
        }

        @NotNull
        public final List<Object> component6() {
            return this.attachmentLinks;
        }

        @NotNull
        /* JADX INFO: renamed from: component7, reason: from getter */
        public final String getCk() {
            return this.ck;
        }

        @NotNull
        public final VideoData copy(boolean hls, @NotNull String videoImage, @NotNull String videoSource, @NotNull String securedLink, @NotNull List<? extends Object> downloadLinks, @NotNull List<? extends Object> attachmentLinks, @NotNull String ck) {
            return new VideoData(hls, videoImage, videoSource, securedLink, downloadLinks, attachmentLinks, ck);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof VideoData)) {
                return false;
            }
            VideoData videoData = (VideoData) other;
            return this.hls == videoData.hls && Intrinsics.areEqual(this.videoImage, videoData.videoImage) && Intrinsics.areEqual(this.videoSource, videoData.videoSource) && Intrinsics.areEqual(this.securedLink, videoData.securedLink) && Intrinsics.areEqual(this.downloadLinks, videoData.downloadLinks) && Intrinsics.areEqual(this.attachmentLinks, videoData.attachmentLinks) && Intrinsics.areEqual(this.ck, videoData.ck);
        }

        public int hashCode() {
            return (((((((((((Tamilian$VideoData$$ExternalSyntheticBackport0.m1m(this.hls) * 31) + this.videoImage.hashCode()) * 31) + this.videoSource.hashCode()) * 31) + this.securedLink.hashCode()) * 31) + this.downloadLinks.hashCode()) * 31) + this.attachmentLinks.hashCode()) * 31) + this.ck.hashCode();
        }

        @NotNull
        public String toString() {
            return "VideoData(hls=" + this.hls + ", videoImage=" + this.videoImage + ", videoSource=" + this.videoSource + ", securedLink=" + this.securedLink + ", downloadLinks=" + this.downloadLinks + ", attachmentLinks=" + this.attachmentLinks + ", ck=" + this.ck + ')';
        }

        public VideoData(boolean hls, @NotNull String videoImage, @NotNull String videoSource, @NotNull String securedLink, @NotNull List<? extends Object> list, @NotNull List<? extends Object> list2, @NotNull String ck) {
            this.hls = hls;
            this.videoImage = videoImage;
            this.videoSource = videoSource;
            this.securedLink = securedLink;
            this.downloadLinks = list;
            this.attachmentLinks = list2;
            this.ck = ck;
        }

        public final boolean getHls() {
            return this.hls;
        }

        @NotNull
        public final String getVideoImage() {
            return this.videoImage;
        }

        @NotNull
        public final String getVideoSource() {
            return this.videoSource;
        }

        @NotNull
        public final String getSecuredLink() {
            return this.securedLink;
        }

        @NotNull
        public final List<Object> getDownloadLinks() {
            return this.downloadLinks;
        }

        @NotNull
        public final List<Object> getAttachmentLinks() {
            return this.attachmentLinks;
        }

        @NotNull
        public final String getCk() {
            return this.ck;
        }
    }

    private final void showSubscriptionPopupIfNeeded() {
        final Context ctx = context;
        if (ctx == null || subscriptionPopupShown) {
            return;
        }
        try {
            boolean isTV = Globals.INSTANCE.isLayout(2);
            if (isTV) {
                return;
            }
        } catch (Exception e) {
        }
        SharedPreferences sharedPreferences = ctx.getSharedPreferences("CNCVerseSubscription", 0);
        boolean isSubscribed = Intrinsics.areEqual(sharedPreferences != null ? sharedPreferences.getString("mode", "ads") : null, "subscription");
        if (isSubscribed) {
            return;
        }
        SharedPreferences _dontShowPrefs = ctx.getSharedPreferences("CNCVerseSubscription", 0);
        if (_dontShowPrefs.getBoolean("dont_show_ads_popup", false)) {
            subscriptionPopupShown = true;
        } else {
            subscriptionPopupShown = true;
            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.Tamilian.Tamilian$$ExternalSyntheticLambda2
                @Override // java.lang.Runnable
                public final void run() {
                    Tamilian.showSubscriptionPopupIfNeeded$lambda$0(ctx);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showSubscriptionPopupIfNeeded$lambda$0(final Context $ctx) {
        try {
            float dp = $ctx.getResources().getDisplayMetrics().density;
            GradientDrawable $this$showSubscriptionPopupIfNeeded_u24lambda_u240_u240 = new GradientDrawable();
            $this$showSubscriptionPopupIfNeeded_u24lambda_u240_u240.setColor(Color.parseColor("#1A1A2E"));
            $this$showSubscriptionPopupIfNeeded_u24lambda_u240_u240.setCornerRadius(16.0f * dp);
            LinearLayout root = new LinearLayout($ctx);
            root.setOrientation(1);
            float f = 24;
            root.setPadding((int) (f * dp), (int) (20 * dp), (int) (f * dp), (int) (16 * dp));
            root.setBackground($this$showSubscriptionPopupIfNeeded_u24lambda_u240_u240);
            TextView $this$showSubscriptionPopupIfNeeded_u24lambda_u240_u242 = new TextView($ctx);
            $this$showSubscriptionPopupIfNeeded_u24lambda_u240_u242.setText("📺 You're in Ads Mode");
            $this$showSubscriptionPopupIfNeeded_u24lambda_u240_u242.setTextColor(-1);
            $this$showSubscriptionPopupIfNeeded_u24lambda_u240_u242.setTextSize(17.0f);
            $this$showSubscriptionPopupIfNeeded_u24lambda_u240_u242.setTypeface(Typeface.DEFAULT_BOLD);
            LinearLayout.LayoutParams it = new LinearLayout.LayoutParams(-1, -2);
            it.bottomMargin = (int) (8 * dp);
            $this$showSubscriptionPopupIfNeeded_u24lambda_u240_u242.setLayoutParams(it);
            View divider = new View($ctx);
            divider.setBackgroundColor(Color.parseColor("#2D2D4A"));
            LinearLayout.LayoutParams it2 = new LinearLayout.LayoutParams(-1, 1);
            it2.bottomMargin = (int) (12 * dp);
            divider.setLayoutParams(it2);
            TextView $this$showSubscriptionPopupIfNeeded_u24lambda_u240_u244 = new TextView($ctx);
            $this$showSubscriptionPopupIfNeeded_u24lambda_u240_u244.setText("All CNCVerse extensions currently run with ads.\n\nSubscribe to remove ads from just ₹20/month.\n\nManage via Settings > Extensions > CNCVerse Cloudstream Repo > Subscription Manager.");
            $this$showSubscriptionPopupIfNeeded_u24lambda_u240_u244.setTextColor(Color.parseColor("#A0A0A8"));
            $this$showSubscriptionPopupIfNeeded_u24lambda_u240_u244.setTextSize(14.0f);
            $this$showSubscriptionPopupIfNeeded_u24lambda_u240_u244.setLineSpacing(0.0f, 1.4f);
            LinearLayout.LayoutParams it3 = new LinearLayout.LayoutParams(-1, -2);
            it3.bottomMargin = (int) (18 * dp);
            $this$showSubscriptionPopupIfNeeded_u24lambda_u240_u244.setLayoutParams(it3);
            LinearLayout btnRow = new LinearLayout($ctx);
            btnRow.setOrientation(0);
            btnRow.setGravity(8388613);
            TextView laterTv = new TextView($ctx);
            laterTv.setText("Maybe Later");
            laterTv.setTextColor(Color.parseColor("#808090"));
            laterTv.setTextSize(14.0f);
            float f2 = 10;
            int p = (int) (f2 * dp);
            laterTv.setPadding(p, p, p, p);
            laterTv.setClickable(true);
            laterTv.setFocusable(true);
            TextView subscribeTv = new TextView($ctx);
            subscribeTv.setText("Subscribe Now");
            subscribeTv.setTextColor(Color.parseColor("#A78BFA"));
            subscribeTv.setTextSize(14.0f);
            subscribeTv.setTypeface(Typeface.DEFAULT_BOLD);
            int p2 = (int) (f2 * dp);
            subscribeTv.setPadding(p2, p2, 0, p2);
            subscribeTv.setClickable(true);
            subscribeTv.setFocusable(true);
            LinearLayout $this$showSubscriptionPopupIfNeeded_u24lambda_u240_u248 = new LinearLayout($ctx);
            $this$showSubscriptionPopupIfNeeded_u24lambda_u240_u248.setOrientation(0);
            $this$showSubscriptionPopupIfNeeded_u24lambda_u240_u248.setGravity(8388627);
            LinearLayout.LayoutParams it4 = new LinearLayout.LayoutParams(-1, -2);
            it4.bottomMargin = (int) (f2 * dp);
            $this$showSubscriptionPopupIfNeeded_u24lambda_u240_u248.setLayoutParams(it4);
            final CheckBox $this$showSubscriptionPopupIfNeeded_u24lambda_u240_u249 = new CheckBox($ctx);
            $this$showSubscriptionPopupIfNeeded_u24lambda_u240_u249.setChecked(false);
            $this$showSubscriptionPopupIfNeeded_u24lambda_u240_u249.setButtonTintList(ColorStateList.valueOf(Color.parseColor("#A78BFA")));
            TextView $this$showSubscriptionPopupIfNeeded_u24lambda_u240_u2410 = new TextView($ctx);
            $this$showSubscriptionPopupIfNeeded_u24lambda_u240_u2410.setText("Don't show me again");
            $this$showSubscriptionPopupIfNeeded_u24lambda_u240_u2410.setTextColor(Color.parseColor("#A0A0A8"));
            $this$showSubscriptionPopupIfNeeded_u24lambda_u240_u2410.setTextSize(13.0f);
            $this$showSubscriptionPopupIfNeeded_u24lambda_u240_u2410.setPadding((int) (6 * dp), 0, 0, 0);
            $this$showSubscriptionPopupIfNeeded_u24lambda_u240_u248.addView($this$showSubscriptionPopupIfNeeded_u24lambda_u240_u249);
            $this$showSubscriptionPopupIfNeeded_u24lambda_u240_u248.addView($this$showSubscriptionPopupIfNeeded_u24lambda_u240_u2410);
            btnRow.addView(laterTv);
            btnRow.addView(subscribeTv);
            root.addView($this$showSubscriptionPopupIfNeeded_u24lambda_u240_u242);
            root.addView(divider);
            root.addView($this$showSubscriptionPopupIfNeeded_u24lambda_u240_u244);
            root.addView($this$showSubscriptionPopupIfNeeded_u24lambda_u240_u248);
            root.addView(btnRow);
            final AlertDialog dialog = new AlertDialog.Builder($ctx).setView(root).setCancelable(true).create();
            Window window = dialog.getWindow();
            if (window != null) {
                window.setBackgroundDrawable(new ColorDrawable(0));
            }
            laterTv.setOnClickListener(new View.OnClickListener() { // from class: com.Tamilian.Tamilian$$ExternalSyntheticLambda3
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    Tamilian.showSubscriptionPopupIfNeeded$lambda$0$11($this$showSubscriptionPopupIfNeeded_u24lambda_u240_u249, $ctx, dialog, view);
                }
            });
            subscribeTv.setOnClickListener(new View.OnClickListener() { // from class: com.Tamilian.Tamilian$$ExternalSyntheticLambda4
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    Tamilian.showSubscriptionPopupIfNeeded$lambda$0$12(dialog, $ctx, view);
                }
            });
            dialog.show();
        } catch (Exception e) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showSubscriptionPopupIfNeeded$lambda$0$11(CheckBox $dontShowCb, Context $ctx, AlertDialog $dialog, View it) {
        if ($dontShowCb.isChecked()) {
            $ctx.getSharedPreferences("CNCVerseSubscription", 0).edit().putBoolean("dont_show_ads_popup", true).apply();
        }
        $dialog.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showSubscriptionPopupIfNeeded$lambda$0$12(AlertDialog $dialog, Context $ctx, View it) {
        $dialog.dismiss();
        try {
            Intent i = new Intent("android.intent.action.VIEW", Uri.parse("https://cncverse-sub.pages.dev"));
            i.addFlags(268435456);
            $ctx.startActivity(i);
        } catch (Exception e) {
        }
    }

    private final void showTelegramPopup() {
        final Context ctx;
        if (Globals.INSTANCE.isLayout(2) || (ctx = context) == null || telegramPopupShown) {
            return;
        }
        SharedPreferences prefs = ctx.getSharedPreferences("cncverse_prefs", 0);
        if (prefs.getBoolean("telegram_popup_shown", false)) {
            telegramPopupShown = true;
            return;
        }
        telegramPopupShown = true;
        prefs.edit().putBoolean("telegram_popup_shown", true).apply();
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.Tamilian.Tamilian$$ExternalSyntheticLambda6
            @Override // java.lang.Runnable
            public final void run() {
                Tamilian.showTelegramPopup$lambda$0(ctx);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showTelegramPopup$lambda$0(final Context $ctx) {
        try {
            float dp = $ctx.getResources().getDisplayMetrics().density;
            GradientDrawable $this$showTelegramPopup_u24lambda_u240_u240 = new GradientDrawable();
            $this$showTelegramPopup_u24lambda_u240_u240.setColor(Color.parseColor("#1A1A2E"));
            $this$showTelegramPopup_u24lambda_u240_u240.setCornerRadius(16.0f * dp);
            LinearLayout root = new LinearLayout($ctx);
            root.setOrientation(1);
            float f = 24;
            root.setPadding((int) (f * dp), (int) (20 * dp), (int) (f * dp), (int) (16 * dp));
            root.setBackground($this$showTelegramPopup_u24lambda_u240_u240);
            TextView $this$showTelegramPopup_u24lambda_u240_u242 = new TextView($ctx);
            $this$showTelegramPopup_u24lambda_u240_u242.setText("💬 Join CNCVerse Community");
            $this$showTelegramPopup_u24lambda_u240_u242.setTextColor(-1);
            $this$showTelegramPopup_u24lambda_u240_u242.setTextSize(17.0f);
            $this$showTelegramPopup_u24lambda_u240_u242.setTypeface(Typeface.DEFAULT_BOLD);
            LinearLayout.LayoutParams it = new LinearLayout.LayoutParams(-1, -2);
            float f2 = 10;
            it.bottomMargin = (int) (f2 * dp);
            $this$showTelegramPopup_u24lambda_u240_u242.setLayoutParams(it);
            View dividerV = new View($ctx);
            dividerV.setBackgroundColor(Color.parseColor("#2D2D4A"));
            LinearLayout.LayoutParams it2 = new LinearLayout.LayoutParams(-1, 1);
            it2.bottomMargin = (int) (14 * dp);
            dividerV.setLayoutParams(it2);
            TextView $this$showTelegramPopup_u24lambda_u240_u244 = new TextView($ctx);
            $this$showTelegramPopup_u24lambda_u240_u244.setText("Join our Telegram group to discuss and share your opinion!");
            $this$showTelegramPopup_u24lambda_u240_u244.setTextColor(Color.parseColor("#A0A0A8"));
            $this$showTelegramPopup_u24lambda_u240_u244.setTextSize(14.0f);
            $this$showTelegramPopup_u24lambda_u240_u244.setLineSpacing(0.0f, 1.4f);
            LinearLayout.LayoutParams it3 = new LinearLayout.LayoutParams(-1, -2);
            it3.bottomMargin = (int) (18 * dp);
            $this$showTelegramPopup_u24lambda_u240_u244.setLayoutParams(it3);
            LinearLayout btnRow = new LinearLayout($ctx);
            btnRow.setOrientation(0);
            btnRow.setGravity(8388613);
            TextView laterTv = new TextView($ctx);
            laterTv.setText("Later");
            laterTv.setTextColor(Color.parseColor("#808090"));
            laterTv.setTextSize(14.0f);
            int p = (int) (f2 * dp);
            laterTv.setPadding(p, p, p, p);
            laterTv.setClickable(true);
            laterTv.setFocusable(true);
            TextView joinTv = new TextView($ctx);
            joinTv.setText("Join Telegram");
            joinTv.setTextColor(Color.parseColor("#5B9BF5"));
            joinTv.setTextSize(14.0f);
            joinTv.setTypeface(Typeface.DEFAULT_BOLD);
            int p2 = (int) (f2 * dp);
            joinTv.setPadding(p2, p2, 0, p2);
            joinTv.setClickable(true);
            joinTv.setFocusable(true);
            btnRow.addView(laterTv);
            btnRow.addView(joinTv);
            root.addView($this$showTelegramPopup_u24lambda_u240_u242);
            root.addView(dividerV);
            root.addView($this$showTelegramPopup_u24lambda_u240_u244);
            root.addView(btnRow);
            final AlertDialog dialog = new AlertDialog.Builder($ctx).setView(root).setCancelable(true).create();
            Window window = dialog.getWindow();
            if (window != null) {
                window.setBackgroundDrawable(new ColorDrawable(0));
            }
            laterTv.setOnClickListener(new View.OnClickListener() { // from class: com.Tamilian.Tamilian$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    dialog.dismiss();
                }
            });
            joinTv.setOnClickListener(new View.OnClickListener() { // from class: com.Tamilian.Tamilian$$ExternalSyntheticLambda1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    Tamilian.showTelegramPopup$lambda$0$9(dialog, $ctx, view);
                }
            });
            dialog.show();
        } catch (Exception e) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showTelegramPopup$lambda$0$9(AlertDialog $dialog, Context $ctx, View it) {
        $dialog.dismiss();
        try {
            Intent i = new Intent("android.intent.action.VIEW", Uri.parse("https://t.me/cncverse"));
            i.addFlags(268435456);
            $ctx.startActivity(i);
        } catch (Exception e) {
        }
    }

    private final void openInExternalBrowser(final String url) {
        final Context ctx;
        if (Globals.INSTANCE.isLayout(2) || (ctx = context) == null) {
            return;
        }
        long now = System.currentTimeMillis();
        if (now - lastBrowserOpenMs < BROWSER_DEBOUNCE_MS) {
            return;
        }
        lastBrowserOpenMs = now;
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.Tamilian.Tamilian$$ExternalSyntheticLambda7
            @Override // java.lang.Runnable
            public final void run() {
                Tamilian.openInExternalBrowser$lambda$0(ctx, url);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void openInExternalBrowser$lambda$0(Context $ctx, String $url) {
        try {
            Intent $this$openInExternalBrowser_u24lambda_u240_u240 = new Intent("android.intent.action.VIEW", Uri.parse($url));
            $this$openInExternalBrowser_u24lambda_u240_u240.addFlags(268435456);
            $ctx.startActivity($this$openInExternalBrowser_u24lambda_u240_u240);
        } catch (Exception e) {
        }
    }
}

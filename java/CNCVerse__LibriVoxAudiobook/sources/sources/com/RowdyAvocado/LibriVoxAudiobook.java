package com.RowdyAvocado;

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
import com.lagradost.cloudstream3.AnimeSearchResponse;
import com.lagradost.cloudstream3.Episode;
import com.lagradost.cloudstream3.HomePageList;
import com.lagradost.cloudstream3.HomePageResponse;
import com.lagradost.cloudstream3.LoadResponse;
import com.lagradost.cloudstream3.MainAPI;
import com.lagradost.cloudstream3.MainAPIKt;
import com.lagradost.cloudstream3.MainActivityKt;
import com.lagradost.cloudstream3.MainPageData;
import com.lagradost.cloudstream3.MainPageRequest;
import com.lagradost.cloudstream3.MovieLoadResponse;
import com.lagradost.cloudstream3.SearchResponse;
import com.lagradost.cloudstream3.SubtitleFile;
import com.lagradost.cloudstream3.TvSeriesLoadResponse;
import com.lagradost.cloudstream3.TvType;
import com.lagradost.cloudstream3.ui.settings.Globals;
import com.lagradost.cloudstream3.utils.ExtractorApiKt;
import com.lagradost.cloudstream3.utils.ExtractorLink;
import com.lagradost.cloudstream3.utils.ExtractorLinkType;
import com.lagradost.cloudstream3.utils.Qualities;
import com.lagradost.nicehttp.NiceResponse;
import com.lagradost.nicehttp.Requests;
import com.lagradost.nicehttp.ResponseParser;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;
import okhttp3.Interceptor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

/* JADX INFO: compiled from: LibriVoxAudiobook.kt */
/* JADX INFO: loaded from: /home/ubuntu/work/NepaliStream-CNC-Repo/decoded/cncverse/LibriVoxAudiobook/classes.dex */
@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 :2\u00020\u0001:\u0003:;<B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001e\u0010\u001e\u001a\u00020 2\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$H\u0096@¢\u0006\u0002\u0010%J\u001c\u0010&\u001a\b\u0012\u0004\u0012\u00020'0\u001c2\u0006\u0010(\u001a\u00020\u0005H\u0096@¢\u0006\u0002\u0010)J\u0018\u0010*\u001a\u0004\u0018\u00010+2\u0006\u0010,\u001a\u00020\u0005H\u0096@¢\u0006\u0002\u0010)J\b\u0010-\u001a\u00020.H\u0002J\b\u0010/\u001a\u00020.H\u0002J\u0010\u00100\u001a\u00020.2\u0006\u0010,\u001a\u00020\u0005H\u0002JF\u00101\u001a\u00020\u000e2\u0006\u00102\u001a\u00020\u00052\u0006\u00103\u001a\u00020\u000e2\u0012\u00104\u001a\u000e\u0012\u0004\u0012\u000206\u0012\u0004\u0012\u00020.052\u0012\u00107\u001a\u000e\u0012\u0004\u0012\u000208\u0012\u0004\u0012\u00020.05H\u0096@¢\u0006\u0002\u00109R\u001a\u0010\u0004\u001a\u00020\u0005X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u0005X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR\u0014\u0010\r\u001a\u00020\u000eX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\u00020\u0005X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0007\"\u0004\b\u0013\u0010\tR\u0014\u0010\u0014\u001a\u00020\u000eX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0010R\u001a\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00180\u0017X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u001a\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001cX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001f¨\u0006="}, d2 = {"Lcom/RowdyAvocado/LibriVoxAudiobook;", "Lcom/lagradost/cloudstream3/MainAPI;", "<init>", "()V", "mainUrl", "", "getMainUrl", "()Ljava/lang/String;", "setMainUrl", "(Ljava/lang/String;)V", "name", "getName", "setName", "hasMainPage", "", "getHasMainPage", "()Z", "lang", "getLang", "setLang", "hasDownloadSupport", "getHasDownloadSupport", "supportedTypes", "", "Lcom/lagradost/cloudstream3/TvType;", "getSupportedTypes", "()Ljava/util/Set;", "mainPage", "", "Lcom/lagradost/cloudstream3/MainPageData;", "getMainPage", "()Ljava/util/List;", "Lcom/lagradost/cloudstream3/HomePageResponse;", "page", "", "request", "Lcom/lagradost/cloudstream3/MainPageRequest;", "(ILcom/lagradost/cloudstream3/MainPageRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "search", "Lcom/lagradost/cloudstream3/SearchResponse;", "query", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "load", "Lcom/lagradost/cloudstream3/LoadResponse;", "url", "showSubscriptionPopupIfNeeded", "", "showTelegramPopup", "openInExternalBrowser", "loadLinks", "data", "isCasting", "subtitleCallback", "Lkotlin/Function1;", "Lcom/lagradost/cloudstream3/SubtitleFile;", "callback", "Lcom/lagradost/cloudstream3/utils/ExtractorLink;", "(Ljava/lang/String;ZLkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "BookList", "Book", "LibriVoxAudiobook_debug"}, k = 1, mv = {2, 3, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nLibriVoxAudiobook.kt\nKotlin\n*S Kotlin\n*F\n+ 1 LibriVoxAudiobook.kt\ncom/RowdyAvocado/LibriVoxAudiobook\n+ 2 NiceResponse.kt\ncom/lagradost/nicehttp/NiceResponse\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 4 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,434:1\n62#2:435\n62#2:450\n1642#3,10:436\n1915#3:446\n1916#3:448\n1652#3:449\n1586#3:451\n1661#3,3:452\n1642#3,10:455\n1915#3:465\n1916#3:467\n1652#3:468\n1#4:447\n1#4:466\n1#4:469\n*S KotlinDebug\n*F\n+ 1 LibriVoxAudiobook.kt\ncom/RowdyAvocado/LibriVoxAudiobook\n*L\n89#1:435\n111#1:450\n91#1:436,10\n91#1:446\n91#1:448\n91#1:449\n113#1:451\n113#1:452,3\n137#1:455,10\n137#1:465\n137#1:467\n137#1:468\n91#1:447\n137#1:466\n*E\n"})
public final class LibriVoxAudiobook extends MainAPI {
    private static final long BROWSER_DEBOUNCE_MS = 10000;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private static final String OMG10 = "aHR0cHM6Ly9vbWcxMC5jb20vNC8xMTEwNDQ4OQ==";

    @Nullable
    private static Context context;
    private static volatile boolean csGuardWasEverActive;
    private static volatile long lastBrowserOpenMs;
    private static volatile boolean subscriptionPopupShown;
    private static volatile boolean telegramPopupShown;

    @NotNull
    private String mainUrl = "https://librivox.org";

    @NotNull
    private String name = "Librivox Audiobook";
    private final boolean hasMainPage = true;

    @NotNull
    private String lang = "en";
    private final boolean hasDownloadSupport = true;

    @NotNull
    private final Set<TvType> supportedTypes = SetsKt.setOf(TvType.Others);

    @NotNull
    private final List<MainPageData> mainPage = CollectionsKt.listOf(new MainPageData("Latest Audiobook", "https://librivox.org/api/feed/audiobooks/title/?format=json", false, 4, (DefaultConstructorMarker) null));

    /* JADX INFO: renamed from: com.RowdyAvocado.LibriVoxAudiobook$getMainPage$1 */
    /* JADX INFO: compiled from: LibriVoxAudiobook.kt */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.RowdyAvocado.LibriVoxAudiobook", f = "LibriVoxAudiobook.kt", i = {0, 0, 0}, l = {89}, m = "getMainPage", n = {"request", "reqlink", "page"}, nl = {435}, s = {"L$0", "L$1", "I$0"}, v = 2)
    static final class C00001 extends ContinuationImpl {
        int I$0;
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        C00001(Continuation<? super C00001> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return LibriVoxAudiobook.this.getMainPage(0, null, (Continuation) this);
        }
    }

    /* JADX INFO: renamed from: com.RowdyAvocado.LibriVoxAudiobook$load$1 */
    /* JADX INFO: compiled from: LibriVoxAudiobook.kt */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.RowdyAvocado.LibriVoxAudiobook", f = "LibriVoxAudiobook.kt", i = {0, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2}, l = {124, 146, 151}, m = "load", n = {"url", "url", "document", "title", "poster", "tvType", "episodes", "url", "document", "title", "poster", "tvType"}, nl = {126, 151, 134}, s = {"L$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$0", "L$1", "L$2", "L$3", "L$4"}, v = 2)
    static final class C00011 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        int label;
        /* synthetic */ Object result;

        C00011(Continuation<? super C00011> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return LibriVoxAudiobook.this.load(null, (Continuation) this);
        }
    }

    /* JADX INFO: renamed from: com.RowdyAvocado.LibriVoxAudiobook$loadLinks$1 */
    /* JADX INFO: compiled from: LibriVoxAudiobook.kt */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.RowdyAvocado.LibriVoxAudiobook", f = "LibriVoxAudiobook.kt", i = {0, 0, 0, 0, 0}, l = {411}, m = "loadLinks", n = {"data", "subtitleCallback", "callback", "name", "isCasting"}, nl = {410}, s = {"L$0", "L$1", "L$2", "L$3", "Z$0"}, v = 2)
    static final class C00041 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        boolean Z$0;
        int label;
        /* synthetic */ Object result;

        C00041(Continuation<? super C00041> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return LibriVoxAudiobook.this.loadLinks(null, false, null, null, (Continuation) this);
        }
    }

    /* JADX INFO: renamed from: com.RowdyAvocado.LibriVoxAudiobook$search$1 */
    /* JADX INFO: compiled from: LibriVoxAudiobook.kt */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.RowdyAvocado.LibriVoxAudiobook", f = "LibriVoxAudiobook.kt", i = {0, 0}, l = {111}, m = "search", n = {"query", "reqlink"}, nl = {435}, s = {"L$0", "L$1"}, v = 2)
    static final class C00061 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        C00061(Continuation<? super C00061> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return LibriVoxAudiobook.this.search(null, (Continuation) this);
        }
    }

    /* JADX INFO: compiled from: LibriVoxAudiobook.kt */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\t\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0004\u001a\u00020\u0005J\u0006\u0010\u0007\u001a\u00020\u0005J\u0012\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0002R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u000fX\u0082T¢\u0006\u0002\n\u0000R\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017¨\u0006\u0018"}, d2 = {"Lcom/RowdyAvocado/LibriVoxAudiobook$Companion;", "", "<init>", "()V", "isCsGuardActive", "", "csGuardWasEverActive", "isCsGuardBlocked", "showCsGuardToast", "", "ctx", "Landroid/content/Context;", "OMG10", "", "lastBrowserOpenMs", "", "telegramPopupShown", "subscriptionPopupShown", "BROWSER_DEBOUNCE_MS", "context", "getContext", "()Landroid/content/Context;", "setContext", "(Landroid/content/Context;)V", "LibriVoxAudiobook_debug"}, k = 1, mv = {2, 3, 0}, xi = 48)
    @SourceDebugExtension({"SMAP\nLibriVoxAudiobook.kt\nKotlin\n*S Kotlin\n*F\n+ 1 LibriVoxAudiobook.kt\ncom/RowdyAvocado/LibriVoxAudiobook$Companion\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,434:1\n1#2:435\n*E\n"})
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX WARN: Code duplicated, block: B:11:0x0042  */
        public final boolean isCsGuardActive() {
            String name;
            Class<?> cls;
            String name2;
            try {
                Class<?> cls2 = Class.forName("android.app.ActivityThread");
                Object thread = cls2.getMethod("currentActivityThread", new Class[0]).invoke(null, new Object[0]);
                Field field = cls2.getDeclaredField("mInstrumentation");
                field.setAccessible(true);
                Object obj = field.get(thread);
                if (obj == null || (cls = obj.getClass()) == null || (name2 = cls.getName()) == null) {
                    name = "";
                } else {
                    name = name2.toLowerCase(Locale.ROOT);
                    Intrinsics.checkNotNullExpressionValue(name, "toLowerCase(...)");
                    if (name == null) {
                        name = "";
                    }
                }
                return StringsKt.contains$default(name, "guard", false, 2, (Object) null) || StringsKt.contains$default(name, "csguard", false, 2, (Object) null);
            } catch (Throwable th) {
                return false;
            }
        }

        public final boolean isCsGuardBlocked() {
            if (isCsGuardActive()) {
                LibriVoxAudiobook.csGuardWasEverActive = true;
            }
            return LibriVoxAudiobook.csGuardWasEverActive;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void showCsGuardToast(final Context ctx) {
            if (ctx == null) {
                return;
            }
            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.RowdyAvocado.LibriVoxAudiobook$Companion$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    LibriVoxAudiobook.Companion.showCsGuardToast$lambda$0(ctx);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void showCsGuardToast$lambda$0(Context $c) {
            Toast.makeText($c, "🚫 CSGuard detected — Restart CloudStream after removing CSGuard to use CNCRepo", 1).show();
        }

        @Nullable
        public final Context getContext() {
            return LibriVoxAudiobook.context;
        }

        public final void setContext(@Nullable Context context) {
            LibriVoxAudiobook.context = context;
        }
    }

    @NotNull
    public String getMainUrl() {
        return this.mainUrl;
    }

    public void setMainUrl(@NotNull String str) {
        this.mainUrl = str;
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

    public boolean getHasDownloadSupport() {
        return this.hasDownloadSupport;
    }

    @NotNull
    public Set<TvType> getSupportedTypes() {
        return this.supportedTypes;
    }

    @NotNull
    public List<MainPageData> getMainPage() {
        return this.mainPage;
    }

    /* JADX WARN: Code duplicated, block: B:26:0x00fd  */
    /* JADX WARN: Code duplicated, block: B:28:0x0130  */
    /* JADX WARN: Code duplicated, block: B:36:0x0139 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    @Nullable
    public Object getMainPage(int page, @NotNull MainPageRequest request, @NotNull Continuation<? super HomePageResponse> continuation) {
        C00001 c00001;
        List listEmptyList;
        MainPageRequest request2;
        Collection destination$iv$iv;
        AnimeSearchResponse animeSearchResponseNewAnimeSearchResponse$default;
        LibriVoxAudiobook libriVoxAudiobook = this;
        if (continuation instanceof C00001) {
            c00001 = (C00001) continuation;
            if ((c00001.label & Integer.MIN_VALUE) != 0) {
                c00001.label -= Integer.MIN_VALUE;
            } else {
                c00001 = libriVoxAudiobook.new C00001(continuation);
            }
        } else {
            c00001 = libriVoxAudiobook.new C00001(continuation);
        }
        Object $result = c00001.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c00001.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                if (INSTANCE.isCsGuardBlocked()) {
                    INSTANCE.showCsGuardToast(context);
                    return MainAPIKt.newHomePageResponse$default(CollectionsKt.emptyList(), (Boolean) null, 2, (Object) null);
                }
                libriVoxAudiobook.showTelegramPopup();
                libriVoxAudiobook.showSubscriptionPopupIfNeeded();
                String reqlink = request.getData();
                if (Intrinsics.areEqual(request.getName(), "Latest Audiobook")) {
                    Requests app = MainActivityKt.getApp();
                    c00001.L$0 = request;
                    c00001.L$1 = SpillingKt.nullOutSpilledVariable(reqlink);
                    c00001.I$0 = page;
                    c00001.label = 1;
                    $result = Requests.get$default(app, reqlink, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00001, 4094, (Object) null);
                    if ($result == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    request2 = request;
                    NiceResponse this_$iv = (NiceResponse) $result;
                    ResponseParser parser = this_$iv.getParser();
                    Intrinsics.checkNotNull(parser);
                    BookList jason = (BookList) parser.parse(this_$iv.getText(), Reflection.getOrCreateKotlinClass(BookList.class));
                    Iterable $this$mapNotNull$iv = jason.getBooks();
                    destination$iv$iv = new ArrayList();
                    for (Object element$iv$iv$iv : $this$mapNotNull$iv) {
                        Book it = (Book) element$iv$iv$iv;
                        String title = it.getTitle();
                        Intrinsics.checkNotNull(title);
                        String url = it.getUrl();
                        Intrinsics.checkNotNull(url);
                        animeSearchResponseNewAnimeSearchResponse$default = MainAPIKt.newAnimeSearchResponse$default(libriVoxAudiobook, title, url, TvType.Anime, false, new Function1() { // from class: com.RowdyAvocado.LibriVoxAudiobook$$ExternalSyntheticLambda9
                            public final Object invoke(Object obj) {
                                return LibriVoxAudiobook.getMainPage$lambda$0$0((AnimeSearchResponse) obj);
                            }
                        }, 8, (Object) null);
                        if (animeSearchResponseNewAnimeSearchResponse$default != null) {
                            destination$iv$iv.add(animeSearchResponseNewAnimeSearchResponse$default);
                        }
                        libriVoxAudiobook = this;
                    }
                    listEmptyList = (List) destination$iv$iv;
                } else {
                    listEmptyList = CollectionsKt.emptyList();
                    request2 = request;
                }
                List home = listEmptyList;
                return MainAPIKt.newHomePageResponse(CollectionsKt.listOf(new HomePageList(request2.getName(), home, false, 4, (DefaultConstructorMarker) null)), Boxing.boxBoolean(!home.isEmpty()));
            case 1:
                int i = c00001.I$0;
                request2 = (MainPageRequest) c00001.L$0;
                ResultKt.throwOnFailure($result);
                NiceResponse this_$iv2 = (NiceResponse) $result;
                ResponseParser parser2 = this_$iv2.getParser();
                Intrinsics.checkNotNull(parser2);
                BookList jason2 = (BookList) parser2.parse(this_$iv2.getText(), Reflection.getOrCreateKotlinClass(BookList.class));
                Iterable $this$mapNotNull$iv2 = jason2.getBooks();
                destination$iv$iv = new ArrayList();
                while (r13.hasNext()) {
                    Book it2 = (Book) element$iv$iv$iv;
                    String title2 = it2.getTitle();
                    Intrinsics.checkNotNull(title2);
                    String url2 = it2.getUrl();
                    Intrinsics.checkNotNull(url2);
                    animeSearchResponseNewAnimeSearchResponse$default = MainAPIKt.newAnimeSearchResponse$default(libriVoxAudiobook, title2, url2, TvType.Anime, false, new Function1() { // from class: com.RowdyAvocado.LibriVoxAudiobook$$ExternalSyntheticLambda9
                        public final Object invoke(Object obj) {
                            return LibriVoxAudiobook.getMainPage$lambda$0$0((AnimeSearchResponse) obj);
                        }
                    }, 8, (Object) null);
                    if (animeSearchResponseNewAnimeSearchResponse$default != null) {
                        destination$iv$iv.add(animeSearchResponseNewAnimeSearchResponse$default);
                    }
                    libriVoxAudiobook = this;
                }
                listEmptyList = (List) destination$iv$iv;
                List home2 = listEmptyList;
                return MainAPIKt.newHomePageResponse(CollectionsKt.listOf(new HomePageList(request2.getName(), home2, false, 4, (DefaultConstructorMarker) null)), Boxing.boxBoolean(!home2.isEmpty()));
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit getMainPage$lambda$0$0(AnimeSearchResponse $this$newAnimeSearchResponse) {
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    @Nullable
    public Object search(@NotNull String query, @NotNull Continuation<? super List<? extends SearchResponse>> continuation) {
        C00061 c00061;
        if (continuation instanceof C00061) {
            c00061 = (C00061) continuation;
            if ((c00061.label & Integer.MIN_VALUE) != 0) {
                c00061.label -= Integer.MIN_VALUE;
            } else {
                c00061 = new C00061(continuation);
            }
        } else {
            c00061 = new C00061(continuation);
        }
        Object $result = c00061.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c00061.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                if (INSTANCE.isCsGuardBlocked()) {
                    INSTANCE.showCsGuardToast(context);
                    return CollectionsKt.emptyList();
                }
                String reqlink = "https://librivox.org/api/feed/audiobooks/?title=" + query + "&format=json";
                Requests app = MainActivityKt.getApp();
                c00061.L$0 = SpillingKt.nullOutSpilledVariable(query);
                c00061.L$1 = SpillingKt.nullOutSpilledVariable(reqlink);
                c00061.label = 1;
                $result = Requests.get$default(app, reqlink, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00061, 4094, (Object) null);
                if ($result == coroutine_suspended) {
                    return coroutine_suspended;
                }
                break;
                break;
            case 1:
                ResultKt.throwOnFailure($result);
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        NiceResponse this_$iv = (NiceResponse) $result;
        ResponseParser parser = this_$iv.getParser();
        Intrinsics.checkNotNull(parser);
        BookList jason = (BookList) parser.parse(this_$iv.getText(), Reflection.getOrCreateKotlinClass(BookList.class));
        Iterable $this$map$iv = jason.getBooks();
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
        for (Object item$iv$iv : $this$map$iv) {
            Book it = (Book) item$iv$iv;
            String title = it.getTitle();
            Intrinsics.checkNotNull(title);
            String url = it.getUrl();
            Intrinsics.checkNotNull(url);
            destination$iv$iv.add(MainAPIKt.newAnimeSearchResponse$default(this, title, url, TvType.Anime, false, new Function1() { // from class: com.RowdyAvocado.LibriVoxAudiobook$$ExternalSyntheticLambda7
                public final Object invoke(Object obj) {
                    return LibriVoxAudiobook.search$lambda$0$0((AnimeSearchResponse) obj);
                }
            }, 8, (Object) null));
        }
        return (List) destination$iv$iv;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit search$lambda$0$0(AnimeSearchResponse $this$newAnimeSearchResponse) {
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    @Nullable
    public Object load(@NotNull String url, @NotNull Continuation<? super LoadResponse> continuation) {
        C00011 c00011;
        Object obj;
        Object obj2;
        String url2;
        Element elementSelectFirst;
        String strText;
        String strAttr;
        Object objNewMovieLoadResponse;
        String url3;
        Document document;
        TvType tvType;
        String url4;
        String title;
        Object objNewTvSeriesLoadResponse;
        if (continuation instanceof C00011) {
            c00011 = (C00011) continuation;
            if ((c00011.label & Integer.MIN_VALUE) != 0) {
                c00011.label -= Integer.MIN_VALUE;
            } else {
                c00011 = new C00011(continuation);
            }
        } else {
            c00011 = new C00011(continuation);
        }
        C00011 c00012 = c00011;
        Object $result = c00012.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c00012.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                Requests app = MainActivityKt.getApp();
                c00012.L$0 = url;
                c00012.label = 1;
                obj = coroutine_suspended;
                obj2 = Requests.get$default(app, url, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00012, 4094, (Object) null);
                c00012 = c00012;
                if (obj2 == obj) {
                    return obj;
                }
                url2 = url;
                Document document2 = ((NiceResponse) obj2).getDocument();
                elementSelectFirst = document2.selectFirst("div.content-wrap h1");
                if (elementSelectFirst != null || (strText = elementSelectFirst.text()) == null) {
                    return null;
                }
                String title2 = StringsKt.trim(strText).toString();
                if (title2 == null) {
                    return null;
                }
                Element elementSelectFirst2 = document2.selectFirst("div.book-page-book-cover img");
                if (elementSelectFirst2 == null || (strAttr = elementSelectFirst2.attr("src")) == null) {
                    strAttr = "https://librivox.org/images/librivox-logo.png";
                }
                String poster = strAttr;
                TvType tvType2 = TvType.TvSeries;
                if (tvType2 != TvType.TvSeries) {
                    TvType tvType3 = TvType.Movie;
                    C00033 c00033 = new C00033(poster, null);
                    c00012.L$0 = SpillingKt.nullOutSpilledVariable(url2);
                    c00012.L$1 = SpillingKt.nullOutSpilledVariable(document2);
                    c00012.L$2 = SpillingKt.nullOutSpilledVariable(title2);
                    c00012.L$3 = SpillingKt.nullOutSpilledVariable(poster);
                    c00012.L$4 = SpillingKt.nullOutSpilledVariable(tvType2);
                    c00012.label = 3;
                    objNewMovieLoadResponse = MainAPIKt.newMovieLoadResponse(this, title2, url2, tvType3, url2, c00033, c00012);
                    if (objNewMovieLoadResponse == obj) {
                        return obj;
                    }
                    url3 = url2;
                    document = document2;
                    tvType = tvType2;
                    url4 = title2;
                    title = poster;
                    return (LoadResponse) objNewMovieLoadResponse;
                }
                Iterable $this$mapNotNull$iv = document2.select("a.chapter-name");
                Collection destination$iv$iv = new ArrayList();
                for (Object element$iv$iv$iv : $this$mapNotNull$iv) {
                    Element it = (Element) element$iv$iv$iv;
                    LibriVoxAudiobook libriVoxAudiobook = this;
                    Object $result2 = $result;
                    String strAttr2 = it.attr("href");
                    if (strAttr2 == null) {
                        return null;
                    }
                    String href = MainAPIKt.fixUrl(libriVoxAudiobook, strAttr2);
                    final String name = StringsKt.trim(it.text()).toString();
                    String title3 = title2;
                    Episode episodeNewEpisode = MainAPIKt.newEpisode(this, href, new Function1() { // from class: com.RowdyAvocado.LibriVoxAudiobook$$ExternalSyntheticLambda3
                        public final Object invoke(Object obj3) {
                            return LibriVoxAudiobook.load$lambda$0$0(name, (Episode) obj3);
                        }
                    });
                    if (episodeNewEpisode != null) {
                        destination$iv$iv.add(episodeNewEpisode);
                    }
                    $result = $result2;
                    title2 = title3;
                }
                String title4 = title2;
                List episodes = (List) destination$iv$iv;
                TvType tvType4 = TvType.TvSeries;
                C00022 c00022 = new C00022(poster, null);
                c00012.L$0 = SpillingKt.nullOutSpilledVariable(url2);
                c00012.L$1 = SpillingKt.nullOutSpilledVariable(document2);
                c00012.L$2 = SpillingKt.nullOutSpilledVariable(title4);
                c00012.L$3 = SpillingKt.nullOutSpilledVariable(poster);
                c00012.L$4 = SpillingKt.nullOutSpilledVariable(tvType2);
                c00012.L$5 = SpillingKt.nullOutSpilledVariable(episodes);
                c00012.label = 2;
                objNewTvSeriesLoadResponse = MainAPIKt.newTvSeriesLoadResponse(this, title4, url2, tvType4, episodes, c00022, c00012);
                return objNewTvSeriesLoadResponse == obj ? obj : (LoadResponse) objNewTvSeriesLoadResponse;
            case 1:
                String url5 = (String) c00012.L$0;
                ResultKt.throwOnFailure($result);
                obj = coroutine_suspended;
                url2 = url5;
                obj2 = $result;
                Document document3 = ((NiceResponse) obj2).getDocument();
                elementSelectFirst = document3.selectFirst("div.content-wrap h1");
                if (elementSelectFirst != null) {
                    break;
                }
                return null;
            case 2:
                ResultKt.throwOnFailure($result);
                objNewTvSeriesLoadResponse = $result;
            case 3:
                tvType = (TvType) c00012.L$4;
                title = (String) c00012.L$3;
                url4 = (String) c00012.L$2;
                document = (Document) c00012.L$1;
                url3 = (String) c00012.L$0;
                ResultKt.throwOnFailure($result);
                objNewMovieLoadResponse = $result;
                return (LoadResponse) objNewMovieLoadResponse;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit load$lambda$0$0(String $name, Episode $this$newEpisode) {
        $this$newEpisode.setName($name);
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: com.RowdyAvocado.LibriVoxAudiobook$load$2 */
    /* JADX INFO: compiled from: LibriVoxAudiobook.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lcom/lagradost/cloudstream3/TvSeriesLoadResponse;"}, k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.RowdyAvocado.LibriVoxAudiobook$load$2", f = "LibriVoxAudiobook.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
    static final class C00022 extends SuspendLambda implements Function2<TvSeriesLoadResponse, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $poster;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C00022(String str, Continuation<? super C00022> continuation) {
            super(2, continuation);
            this.$poster = str;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Continuation<Unit> c00022 = new C00022(this.$poster, continuation);
            c00022.L$0 = obj;
            return c00022;
        }

        public final Object invoke(TvSeriesLoadResponse tvSeriesLoadResponse, Continuation<? super Unit> continuation) {
            return create(tvSeriesLoadResponse, continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object $result) {
            TvSeriesLoadResponse $this$newTvSeriesLoadResponse = (TvSeriesLoadResponse) this.L$0;
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    $this$newTvSeriesLoadResponse.setPosterUrl(this.$poster.toString());
                    return Unit.INSTANCE;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }

    /* JADX INFO: renamed from: com.RowdyAvocado.LibriVoxAudiobook$load$3 */
    /* JADX INFO: compiled from: LibriVoxAudiobook.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lcom/lagradost/cloudstream3/MovieLoadResponse;"}, k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.RowdyAvocado.LibriVoxAudiobook$load$3", f = "LibriVoxAudiobook.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
    static final class C00033 extends SuspendLambda implements Function2<MovieLoadResponse, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $poster;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C00033(String str, Continuation<? super C00033> continuation) {
            super(2, continuation);
            this.$poster = str;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Continuation<Unit> c00033 = new C00033(this.$poster, continuation);
            c00033.L$0 = obj;
            return c00033;
        }

        public final Object invoke(MovieLoadResponse movieLoadResponse, Continuation<? super Unit> continuation) {
            return create(movieLoadResponse, continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object $result) {
            MovieLoadResponse $this$newMovieLoadResponse = (MovieLoadResponse) this.L$0;
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    $this$newMovieLoadResponse.setPosterUrl(this.$poster.toString());
                    return Unit.INSTANCE;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
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
            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.RowdyAvocado.LibriVoxAudiobook$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    LibriVoxAudiobook.showSubscriptionPopupIfNeeded$lambda$0(ctx);
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
            $this$showSubscriptionPopupIfNeeded_u24lambda_u240_u244.setText("All CNCVerse extensions currently run with ads.\n\nSubscribe to remove ads from just ₹30/month.\n\nManage via Settings > Extensions > CNCVerse Cloudstream Repo > Subscription Manager.");
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
            laterTv.setOnClickListener(new View.OnClickListener() { // from class: com.RowdyAvocado.LibriVoxAudiobook$$ExternalSyntheticLambda1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    LibriVoxAudiobook.showSubscriptionPopupIfNeeded$lambda$0$11($this$showSubscriptionPopupIfNeeded_u24lambda_u240_u249, $ctx, dialog, view);
                }
            });
            subscribeTv.setOnClickListener(new View.OnClickListener() { // from class: com.RowdyAvocado.LibriVoxAudiobook$$ExternalSyntheticLambda2
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    LibriVoxAudiobook.showSubscriptionPopupIfNeeded$lambda$0$12(dialog, $ctx, view);
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
        boolean isTV;
        final Context ctx = context;
        if (ctx == null || telegramPopupShown) {
            return;
        }
        try {
            isTV = Globals.INSTANCE.isLayout(2);
        } catch (Exception e) {
            isTV = false;
        }
        if (isTV) {
            return;
        }
        SharedPreferences prefs = ctx.getSharedPreferences("cncverse_prefs", 0);
        if (prefs.getBoolean("telegram_popup_shown", false)) {
            telegramPopupShown = true;
            return;
        }
        telegramPopupShown = true;
        prefs.edit().putBoolean("telegram_popup_shown", true).apply();
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.RowdyAvocado.LibriVoxAudiobook$$ExternalSyntheticLambda10
            @Override // java.lang.Runnable
            public final void run() {
                LibriVoxAudiobook.showTelegramPopup$lambda$0(ctx);
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
            laterTv.setOnClickListener(new View.OnClickListener() { // from class: com.RowdyAvocado.LibriVoxAudiobook$$ExternalSyntheticLambda5
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    dialog.dismiss();
                }
            });
            joinTv.setOnClickListener(new View.OnClickListener() { // from class: com.RowdyAvocado.LibriVoxAudiobook$$ExternalSyntheticLambda6
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    LibriVoxAudiobook.showTelegramPopup$lambda$0$9(dialog, $ctx, view);
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
        boolean isTV;
        final Context ctx = context;
        if (ctx == null) {
            return;
        }
        try {
            isTV = Globals.INSTANCE.isLayout(2);
        } catch (Exception e) {
            isTV = false;
        }
        if (isTV) {
            return;
        }
        long now = System.currentTimeMillis();
        if (now - lastBrowserOpenMs < BROWSER_DEBOUNCE_MS) {
            return;
        }
        lastBrowserOpenMs = now;
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.RowdyAvocado.LibriVoxAudiobook$$ExternalSyntheticLambda8
            @Override // java.lang.Runnable
            public final void run() {
                LibriVoxAudiobook.openInExternalBrowser$lambda$0(ctx, url);
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

    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    @Nullable
    public Object loadLinks(@NotNull String data, boolean isCasting, @NotNull Function1<? super SubtitleFile, Unit> function1, @NotNull Function1<? super ExtractorLink, Unit> function2, @NotNull Continuation<? super Boolean> continuation) {
        C00041 c00041;
        Function1<? super ExtractorLink, Unit> function3;
        boolean z;
        Object objNewExtractorLink;
        if (continuation instanceof C00041) {
            c00041 = (C00041) continuation;
            if ((c00041.label & Integer.MIN_VALUE) != 0) {
                c00041.label -= Integer.MIN_VALUE;
            } else {
                c00041 = new C00041(continuation);
            }
        } else {
            c00041 = new C00041(continuation);
        }
        C00041 c00042 = c00041;
        Object $result = c00042.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c00042.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                LibriVoxAudiobook $this$loadLinks_u24lambda_u240 = this;
                final Context _ctx = context;
                SharedPreferences _prefs = _ctx != null ? _ctx.getSharedPreferences("CNCVerseSubscription", 0) : null;
                String _mode = _prefs != null ? _prefs.getString("mode", "ads") : null;
                long _expiresAt = _prefs != null ? _prefs.getLong("expires_at", 0L) : 0L;
                long _nowSec = System.currentTimeMillis() / 1000;
                boolean _isSubscribed = Intrinsics.areEqual(_mode, "subscription") && (_expiresAt == 0 || _expiresAt > _nowSec);
                if (!_isSubscribed) {
                    if (Intrinsics.areEqual(_mode, "subscription") && _expiresAt > 0 && _expiresAt <= _nowSec) {
                        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.RowdyAvocado.LibriVoxAudiobook$$ExternalSyntheticLambda4
                            @Override // java.lang.Runnable
                            public final void run() {
                                LibriVoxAudiobook.loadLinks$lambda$0$0(_ctx);
                            }
                        });
                    }
                    $this$loadLinks_u24lambda_u240.openInExternalBrowser(new String(Base64.decode(OMG10, 0), Charsets.UTF_8));
                }
                ExtractorLinkType infer_type = ExtractorApiKt.getINFER_TYPE();
                C00053 c00053 = new C00053(null);
                c00042.L$0 = SpillingKt.nullOutSpilledVariable(data);
                c00042.L$1 = SpillingKt.nullOutSpilledVariable(function1);
                c00042.L$2 = SpillingKt.nullOutSpilledVariable(function2);
                c00042.L$3 = SpillingKt.nullOutSpilledVariable("Librivox Audiobook");
                function3 = function2;
                c00042.L$4 = function3;
                c00042.Z$0 = isCasting;
                z = true;
                c00042.label = 1;
                objNewExtractorLink = ExtractorApiKt.newExtractorLink("Librivox Audiobook", "Librivox Audiobook", data, infer_type, c00053, c00042);
                if (objNewExtractorLink == coroutine_suspended) {
                    return coroutine_suspended;
                }
                break;
            case 1:
                boolean z2 = c00042.Z$0;
                Function1<? super ExtractorLink, Unit> function4 = (Function1) c00042.L$4;
                ResultKt.throwOnFailure($result);
                function3 = function4;
                z = true;
                objNewExtractorLink = $result;
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        function3.invoke(objNewExtractorLink);
        return Boxing.boxBoolean(z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void loadLinks$lambda$0$0(Context $_ctx) {
        Toast.makeText($_ctx, "⚠️(Opening ads) Subscription expired. If you have renewed your subscription, please re-verify it in Subscription Manager.", 1).show();
    }

    /* JADX INFO: renamed from: com.RowdyAvocado.LibriVoxAudiobook$loadLinks$3 */
    /* JADX INFO: compiled from: LibriVoxAudiobook.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lcom/lagradost/cloudstream3/utils/ExtractorLink;"}, k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.RowdyAvocado.LibriVoxAudiobook$loadLinks$3", f = "LibriVoxAudiobook.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
    static final class C00053 extends SuspendLambda implements Function2<ExtractorLink, Continuation<? super Unit>, Object> {
        private /* synthetic */ Object L$0;
        int label;

        C00053(Continuation<? super C00053> continuation) {
            super(2, continuation);
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Continuation<Unit> c00053 = LibriVoxAudiobook.this.new C00053(continuation);
            c00053.L$0 = obj;
            return c00053;
        }

        public final Object invoke(ExtractorLink extractorLink, Continuation<? super Unit> continuation) {
            return create(extractorLink, continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object $result) {
            ExtractorLink $this$newExtractorLink = (ExtractorLink) this.L$0;
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    $this$newExtractorLink.setReferer(LibriVoxAudiobook.this.getMainUrl() + '/');
                    $this$newExtractorLink.setQuality(Qualities.P360.getValue());
                    return Unit.INSTANCE;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }

    /* JADX INFO: compiled from: LibriVoxAudiobook.kt */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B!\u0012\u0018\b\u0003\u0010\u0002\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0019\u0010\n\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u0005HÆ\u0003J#\u0010\u000b\u001a\u00020\u00002\u0018\b\u0003\u0010\u0002\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u0005HÆ\u0001J\u0014\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u000f\u001a\u00020\u0010HÖ\u0081\u0004J\n\u0010\u0011\u001a\u00020\u0012HÖ\u0081\u0004R&\u0010\u0002\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u0013"}, d2 = {"Lcom/RowdyAvocado/LibriVoxAudiobook$BookList;", "", "books", "Ljava/util/ArrayList;", "Lcom/RowdyAvocado/LibriVoxAudiobook$Book;", "Lkotlin/collections/ArrayList;", "<init>", "(Ljava/util/ArrayList;)V", "getBooks", "()Ljava/util/ArrayList;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "LibriVoxAudiobook_debug"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final /* data */ class BookList {

        @JsonProperty("books")
        @NotNull
        private final ArrayList<Book> books;

        /* JADX WARN: Illegal instructions before constructor call */
        public BookList() {
            ArrayList arrayList = null;
            this(arrayList, 1, arrayList);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ BookList copy$default(BookList bookList, ArrayList arrayList, int i, Object obj) {
            if ((i & 1) != 0) {
                arrayList = bookList.books;
            }
            return bookList.copy(arrayList);
        }

        @NotNull
        public final ArrayList<Book> component1() {
            return this.books;
        }

        @NotNull
        public final BookList copy(@JsonProperty("books") @NotNull ArrayList<Book> books) {
            return new BookList(books);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof BookList) && Intrinsics.areEqual(this.books, ((BookList) other).books);
        }

        public int hashCode() {
            return this.books.hashCode();
        }

        @NotNull
        public String toString() {
            return "BookList(books=" + this.books + ')';
        }

        public BookList(@JsonProperty("books") @NotNull ArrayList<Book> arrayList) {
            this.books = arrayList;
        }

        public /* synthetic */ BookList(ArrayList arrayList, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? new ArrayList() : arrayList);
        }

        @NotNull
        public final ArrayList<Book> getBooks() {
            return this.books;
        }
    }

    /* JADX INFO: compiled from: LibriVoxAudiobook.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B+\u0012\n\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J-\u0010\u000f\u001a\u00020\u00002\n\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0005\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0014\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0013\u001a\u00020\u0014HÖ\u0081\u0004J\n\u0010\u0015\u001a\u00020\u0003HÖ\u0081\u0004R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\t¨\u0006\u0016"}, d2 = {"Lcom/RowdyAvocado/LibriVoxAudiobook$Book;", "", "id", "", "title", "url", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getId", "()Ljava/lang/String;", "getTitle", "getUrl", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "LibriVoxAudiobook_debug"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final /* data */ class Book {

        @JsonProperty("id")
        @Nullable
        private final String id;

        @JsonProperty("title")
        @Nullable
        private final String title;

        @JsonProperty("url_librivox")
        @Nullable
        private final String url;

        public Book() {
            this(null, null, null, 7, null);
        }

        public static /* synthetic */ Book copy$default(Book book, String str, String str2, String str3, int i, Object obj) {
            if ((i & 1) != 0) {
                str = book.id;
            }
            if ((i & 2) != 0) {
                str2 = book.title;
            }
            if ((i & 4) != 0) {
                str3 = book.url;
            }
            return book.copy(str, str2, str3);
        }

        @Nullable
        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getId() {
            return this.id;
        }

        @Nullable
        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getTitle() {
            return this.title;
        }

        @Nullable
        /* JADX INFO: renamed from: component3, reason: from getter */
        public final String getUrl() {
            return this.url;
        }

        @NotNull
        public final Book copy(@JsonProperty("id") @Nullable String id, @JsonProperty("title") @Nullable String title, @JsonProperty("url_librivox") @Nullable String url) {
            return new Book(id, title, url);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Book)) {
                return false;
            }
            Book book = (Book) other;
            return Intrinsics.areEqual(this.id, book.id) && Intrinsics.areEqual(this.title, book.title) && Intrinsics.areEqual(this.url, book.url);
        }

        public int hashCode() {
            return ((((this.id == null ? 0 : this.id.hashCode()) * 31) + (this.title == null ? 0 : this.title.hashCode())) * 31) + (this.url != null ? this.url.hashCode() : 0);
        }

        @NotNull
        public String toString() {
            return "Book(id=" + this.id + ", title=" + this.title + ", url=" + this.url + ')';
        }

        public Book(@JsonProperty("id") @Nullable String id, @JsonProperty("title") @Nullable String title, @JsonProperty("url_librivox") @Nullable String url) {
            this.id = id;
            this.title = title;
            this.url = url;
        }

        public /* synthetic */ Book(String str, String str2, String str3, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : str3);
        }

        @Nullable
        public final String getId() {
            return this.id;
        }

        @Nullable
        public final String getTitle() {
            return this.title;
        }

        @Nullable
        public final String getUrl() {
            return this.url;
        }
    }
}

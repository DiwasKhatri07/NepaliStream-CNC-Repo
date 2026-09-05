package com.Fibwatch;

import com.lagradost.cloudstream3.MainAPIKt;
import com.lagradost.cloudstream3.MainPageData;
import com.lagradost.cloudstream3.TvType;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.SetsKt;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlinx.coroutines.BuildersKt;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: FibWatchDrama.kt */
/* JADX INFO: loaded from: /home/runner/work/NepaliStream-CNC-Repo/NepaliStream-CNC-Repo/decoded/Fibwatch/Phisher98/java/classes.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u001a\u0010\u0004\u001a\u00020\u0005X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u0005X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR\u0014\u0010\r\u001a\u00020\u000eX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\u00020\u0005X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0007\"\u0004\b\u0013\u0010\tR\u0014\u0010\u0014\u001a\u00020\u000eX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0010R\u001a\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00180\u0017X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u001a\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001cX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001f¨\u0006 "}, d2 = {"Lcom/Fibwatch/Fibwatchdrama;", "Lcom/Fibwatch/Fibwatch;", "<init>", "()V", "mainUrl", "", "getMainUrl", "()Ljava/lang/String;", "setMainUrl", "(Ljava/lang/String;)V", "name", "getName", "setName", "hasMainPage", "", "getHasMainPage", "()Z", "lang", "getLang", "setLang", "hasDownloadSupport", "getHasDownloadSupport", "supportedTypes", "", "Lcom/lagradost/cloudstream3/TvType;", "getSupportedTypes", "()Ljava/util/Set;", "mainPage", "", "Lcom/lagradost/cloudstream3/MainPageData;", "getMainPage", "()Ljava/util/List;", "Fibwatch"}, k = 1, mv = {2, 4, 0}, xi = 48)
public final class Fibwatchdrama extends Fibwatch {

    @NotNull
    private String mainUrl = (String) BuildersKt.runBlockingK(EmptyCoroutineContext.INSTANCE, new Fibwatchdrama$mainUrl$1(null));

    @NotNull
    private String name = "FibWatch Drama";
    private final boolean hasMainPage = true;

    @NotNull
    private String lang = "hi";
    private final boolean hasDownloadSupport = true;

    @NotNull
    private final Set<TvType> supportedTypes = SetsKt.setOf(new TvType[]{TvType.Movie, TvType.TvSeries, TvType.AsianDrama});

    @NotNull
    private final List<MainPageData> mainPage = MainAPIKt.mainPageOf(new Pair[]{TuplesKt.to("videos/top", "Top Videos"), TuplesKt.to("videos/latest", "Latest Videos")});

    @Override // com.Fibwatch.Fibwatch
    @NotNull
    public String getMainUrl() {
        return this.mainUrl;
    }

    @Override // com.Fibwatch.Fibwatch
    public void setMainUrl(@NotNull String str) {
        this.mainUrl = str;
    }

    @Override // com.Fibwatch.Fibwatch
    @NotNull
    public String getName() {
        return this.name;
    }

    @Override // com.Fibwatch.Fibwatch
    public void setName(@NotNull String str) {
        this.name = str;
    }

    @Override // com.Fibwatch.Fibwatch
    public boolean getHasMainPage() {
        return this.hasMainPage;
    }

    @Override // com.Fibwatch.Fibwatch
    @NotNull
    public String getLang() {
        return this.lang;
    }

    @Override // com.Fibwatch.Fibwatch
    public void setLang(@NotNull String str) {
        this.lang = str;
    }

    @Override // com.Fibwatch.Fibwatch
    public boolean getHasDownloadSupport() {
        return this.hasDownloadSupport;
    }

    @Override // com.Fibwatch.Fibwatch
    @NotNull
    public Set<TvType> getSupportedTypes() {
        return this.supportedTypes;
    }

    @Override // com.Fibwatch.Fibwatch
    @NotNull
    public List<MainPageData> getMainPage() {
        return this.mainPage;
    }
}

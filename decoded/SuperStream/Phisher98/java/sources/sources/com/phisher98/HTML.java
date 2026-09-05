package com.phisher98;

import com.fasterxml.jackson.annotation.JsonProperty;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: SuperStreamParser.kt */
/* JADX INFO: loaded from: /home/runner/work/NepaliStream-CNC-Repo/NepaliStream-CNC-Repo/decoded/SuperStream/Phisher98/java/classes.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0006\n\u0002\b\u0019\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001Bw\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0016\b\u0001\u0010\u0006\u001a\u00020\u0005:\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0016\b\u0001\u0010\n\u001a\u00020\u0005:\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u000b\u0012\u0016\b\u0001\u0010\f\u001a\u00020\u0005:\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u000f\u0012\u0006\u0010\u0011\u001a\u00020\u000f¢\u0006\u0004\b\u0012\u0010\u0013J\t\u0010\u001f\u001a\u00020\u0003HÆ\u0003J\t\u0010 \u001a\u00020\u0005HÆ\u0003J\t\u0010!\u001a\u00020\u0005HÆ\u0003J\t\u0010\"\u001a\u00020\u0005HÆ\u0003J\t\u0010#\u001a\u00020\u0005HÆ\u0003J\t\u0010$\u001a\u00020\u000fHÆ\u0003J\t\u0010%\u001a\u00020\u000fHÆ\u0003J\t\u0010&\u001a\u00020\u000fHÆ\u0003J\u0083\u0001\u0010'\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u0016\b\u0003\u0010\u0006\u001a\u00020\u0005:\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t2\u0016\b\u0003\u0010\n\u001a\u00020\u0005:\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u000b2\u0016\b\u0003\u0010\f\u001a\u00020\u0005:\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u000f2\b\b\u0002\u0010\u0011\u001a\u00020\u000fHÆ\u0001J\u0014\u0010(\u001a\u00020)2\b\u0010*\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010+\u001a\u00020,HÖ\u0081\u0004J\n\u0010-\u001a\u00020\u0005HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0017R\u0011\u0010\n\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0017R\u0011\u0010\f\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0017R\u0011\u0010\u000e\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0011\u0010\u0010\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001cR\u0011\u0010\u0011\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001c¨\u0006."}, d2 = {"Lcom/phisher98/HTML;", "", "code", "", "html", "", "pathHtml", "Lcom/fasterxml/jackson/annotation/JsonProperty;", "value", "path_html", "pathHtml2", "path_html2", "fileName", "file_name", "starttime", "", "starttime2", "endtime", "<init>", "(JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;DDD)V", "getCode", "()J", "getHtml", "()Ljava/lang/String;", "getPathHtml", "getPathHtml2", "getFileName", "getStarttime", "()D", "getStarttime2", "getEndtime", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", "", "other", "hashCode", "", "toString", "SuperStream"}, k = 1, mv = {2, 4, 0}, xi = 48)
public final /* data */ class HTML {
    private final long code;
    private final double endtime;

    @NotNull
    private final String fileName;

    @NotNull
    private final String html;

    @NotNull
    private final String pathHtml;

    @NotNull
    private final String pathHtml2;
    private final double starttime;
    private final double starttime2;

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final long getCode() {
        return this.code;
    }

    @NotNull
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getHtml() {
        return this.html;
    }

    @NotNull
    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getPathHtml() {
        return this.pathHtml;
    }

    @NotNull
    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getPathHtml2() {
        return this.pathHtml2;
    }

    @NotNull
    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getFileName() {
        return this.fileName;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final double getStarttime() {
        return this.starttime;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final double getStarttime2() {
        return this.starttime2;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final double getEndtime() {
        return this.endtime;
    }

    @NotNull
    public final HTML copy(long code, @NotNull String html, @JsonProperty("path_html") @NotNull String pathHtml, @JsonProperty("path_html2") @NotNull String pathHtml2, @JsonProperty("file_name") @NotNull String fileName, double starttime, double starttime2, double endtime) {
        return new HTML(code, html, pathHtml, pathHtml2, fileName, starttime, starttime2, endtime);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof HTML)) {
            return false;
        }
        HTML html = (HTML) other;
        return this.code == html.code && Intrinsics.areEqual(this.html, html.html) && Intrinsics.areEqual(this.pathHtml, html.pathHtml) && Intrinsics.areEqual(this.pathHtml2, html.pathHtml2) && Intrinsics.areEqual(this.fileName, html.fileName) && Double.compare(this.starttime, html.starttime) == 0 && Double.compare(this.starttime2, html.starttime2) == 0 && Double.compare(this.endtime, html.endtime) == 0;
    }

    public int hashCode() {
        return (((((((((((((HTML$$ExternalSyntheticBackport0.m4m(this.code) * 31) + this.html.hashCode()) * 31) + this.pathHtml.hashCode()) * 31) + this.pathHtml2.hashCode()) * 31) + this.fileName.hashCode()) * 31) + HTML$$ExternalSyntheticBackport1.m5m(this.starttime)) * 31) + HTML$$ExternalSyntheticBackport1.m5m(this.starttime2)) * 31) + HTML$$ExternalSyntheticBackport1.m5m(this.endtime);
    }

    @NotNull
    public String toString() {
        return "HTML(code=" + this.code + ", html=" + this.html + ", pathHtml=" + this.pathHtml + ", pathHtml2=" + this.pathHtml2 + ", fileName=" + this.fileName + ", starttime=" + this.starttime + ", starttime2=" + this.starttime2 + ", endtime=" + this.endtime + ')';
    }

    public HTML(long code, @NotNull String html, @JsonProperty("path_html") @NotNull String pathHtml, @JsonProperty("path_html2") @NotNull String pathHtml2, @JsonProperty("file_name") @NotNull String fileName, double starttime, double starttime2, double endtime) {
        this.code = code;
        this.html = html;
        this.pathHtml = pathHtml;
        this.pathHtml2 = pathHtml2;
        this.fileName = fileName;
        this.starttime = starttime;
        this.starttime2 = starttime2;
        this.endtime = endtime;
    }

    public final long getCode() {
        return this.code;
    }

    @NotNull
    public final String getHtml() {
        return this.html;
    }

    @NotNull
    public final String getPathHtml() {
        return this.pathHtml;
    }

    @NotNull
    public final String getPathHtml2() {
        return this.pathHtml2;
    }

    @NotNull
    public final String getFileName() {
        return this.fileName;
    }

    public final double getStarttime() {
        return this.starttime;
    }

    public final double getStarttime2() {
        return this.starttime2;
    }

    public final double getEndtime() {
        return this.endtime;
    }
}
